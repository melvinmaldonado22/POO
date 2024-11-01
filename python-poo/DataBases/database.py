import pymysql

class Database:
    def __init__(self, host='localhost', user='root', password='', db='registro'):
        self.connection = pymysql.connect(
            host=host,
            user=user,
            password=password,
            db=db
        )
        self.cursor = self.connection.cursor()
    
    def close(self):
        self.cursor.close()
        self.connection.close()
