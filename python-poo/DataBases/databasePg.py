import psycopg2

try:
    conn = psycopg2.connect(
        host='localhost', 
        user='postgres', 
        password='root', 
        database='descanso_nomada',
        port='5432'
    )
    print('Conexión exitosa con PostgreSQL !')
    cursor = conn.cursor()
    cursor.execute("SELECT * FROM tbl_usuarios")
    rows = cursor.fetchall()
    for row in rows:
        print('Fila' ,row)
except Exception as ex:
    print(ex)