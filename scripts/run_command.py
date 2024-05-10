import os


def run(command):
    return os.popen(command).read()
