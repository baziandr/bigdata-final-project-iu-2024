"""Building the database for project"""

from pprint import pprint
import os
import psycopg2 as psql

# Read password from secrets file
password_path = os.path.join(
    '/',
    'home',
    'team6',
    'project',
    'bigdata-final-project-iu-2024',
    'scripts',
    'secrets',
    '.psql.pass'
)
with open(password_path, "r", encoding="utf-8") as file:
    password = file.read().rstrip()

# build connection string
CONN_STRING=f"host=hadoop-04.uni.innopolis.ru \
port=5432 \
user=team6 \
dbname=team6_projectdb \
password={password}"


# Connect to the remote dbms
with psql.connect(CONN_STRING) as conn:
    # Create a cursor for executing psql commands
    cur = conn.cursor()
    # Read the commands from the file and execute them.
    path_to_create_tables = os.path.join("sql", "create_tables.sql")
    with open(path_to_create_tables, encoding="utf-8") as file:
        content = file.read()
        cur.execute(content)
    conn.commit()

    # Read the commands from the file and execute them.
    path_to_import_data = os.path.join("sql", "import_data.sql")
    with open(path_to_import_data, encoding="utf-8") as file:
        commands = file.readlines()
        path_to_data = os.path.join("data", "original_data.csv")
        with open(path_to_data, "r", encoding="utf-8") as items:
            cur.copy_expert(commands[0], items)

    # If the sql statements are CRUD then you need to commit the change
    conn.commit()

    # Covert item_creation_date from text to datetime
    path_to_create_datetime = os.path.join("sql", "create_datetime.sql")
    with open(path_to_create_datetime, encoding="utf-8") as file:
        content = file.read()
        cur.execute(content)
    conn.commit()

    pprint(conn)
    cur = conn.cursor()
    # Read the sql commands from the file
    path_to_test_database = os.path.join("sql", "test_database.sql")
    with open(path_to_test_database, encoding="utf-8") as file:
        commands = file.readlines()
        for command in commands:
            cur.execute(command)
            # Read all records and print them
            pprint(cur.fetchall())
