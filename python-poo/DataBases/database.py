import pymysql

class Database:
    def __init__(self, host='bv1bgx6yniwakcmhh1w2-mysql.services.clever-cloud.com', user='uglgrub1myyug9eq', password='JAubBmKBcm46lVKnayd0', db='bv1bgx6yniwakcmhh1w2'):
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
