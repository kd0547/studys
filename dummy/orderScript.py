from faker import Faker
import mysql.connector
import random

fake = Faker()

conn = mysql.connector.connect(
    host='localhost',       # 예: 'localhost' 또는 실제 호스트 주소
    user='study_user',   # 본인의 사용자 이름
    password='study_password',  # 본인의 비밀번호
    database='study_db',   # 사용할 데이터베이스 이름
    port='3309'
)
cursor = conn.cursor()
#insert_sql = "INSERT INTO customers (name, email) VALUES (%s, %s)"

#data = [(fake.name(), fake.email()) for _ in range(10000)]
#cursor.executemany(insert_sql, data)
#conn.commit()

insert_sql = "INSERT INTO orders (customer_id, total_amount,order_date) VALUES (%s, %s,%s)"
data = [(random.randrange(1,10001),
         fake.pyint(min_value=10000,max_value= 99999),
         fake.date_between(start_date='-2y', end_date='now')) for _ in range(2000000)]

cursor.executemany(insert_sql, data)
conn.commit()

