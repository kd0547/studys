from faker import Faker
import mysql.connector
import random

fake = Faker()

conn = mysql.connector.connect(
    host='localhost',       # 예: 'localhost' 또는 실제 호스트 주소
    user='test_user',   # 본인의 사용자 이름
    password='test_password',  # 본인의 비밀번호
    database='test_db',   # 사용할 데이터베이스 이름
    port='3307'
)
cursor = conn.cursor()
#insert_sql = "INSERT INTO customers (name, email) VALUES (%s, %s)"

#data = [(fake.name(), fake.email()) for _ in range(10000)]
#cursor.executemany(insert_sql, data)
#conn.commit()

for i in range(1000):
    insert_sql = "INSERT INTO board (id,author, create_at,update_at,subject,title) VALUES (%s,%s,%s,%s,%s,%s)"
    data = [((i * 10000) + j,
             fake.name(),
             now := fake.date_time_between(start_date='-2y', end_date='now'),
             fake.date_time_between(start_date=now, end_date='now'),
             fake.sentence(),
             fake.text()
             ) for j in range(10000)]
    print(i)
    cursor.executemany(insert_sql, data)
    conn.commit()

