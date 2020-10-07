import pymysql
import time
import RPi.GPIO as GPIO
import smbus

GPIO.setmode(GPIO.BCM)

LED1_1=24
LED1_2=22
LED2_1=25
LED2_2=5
LED3_1=12
LED3_2=6
LED4_1=16
LED4_2=13
LED5_1=20
LED5_2=19
LED6_1=21
LED6_2=26

GPIO.setup(LED1_1, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(LED1_2, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(LED2_1, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(LED2_2, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(LED3_1, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(LED3_2, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(LED4_1, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(LED4_2, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(LED5_1, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(LED5_2, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(LED6_1, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(LED6_2, GPIO.OUT, initial=GPIO.LOW)

subway_id = 1

station=["영남대","임당","정평","사월","신매","고산","대공원","연호","담티","만촌","수성구청","범어","대구은행","경대병원","반월당","청라언덕","반고개","내당","두류","감삼","죽전","용산","이곡","성서산업단지","계명대"
,"강창","대실","다사","문양"]

conn = pymysql.connect(host='localhost', user='root', password='1234', db='subway', charset='utf8')

curs = conn.cursor()
curs.execute("select * from reservation where subway_num = %s",subway_id)

cnt = curs.rowcount
row = curs.fetchall()

i = 0
j = 0
flag=0
try:
    while True:
        for i in range(cnt):
            if row[i][2]==j:
                if row[i][8]==1:
                    if row[i][9]==1:
                        print(station[j]+" 1-1 on")
                        GPIO.output(LED1_1, GPIO.HIGH)
                        flag=1
                    else:
                        print(station[j]+" 1-2 on")
                        GPIO.output(LED1_2, GPIO.HIGH)
                        flag=1
                elif row[i][8]==2:
                    if row[i][9]==1:
                        print(station[j]+" 2-1 on")
                        GPIO.output(LED2_1, GPIO.HIGH)
                        flag=1
                    else:
                        print(station[j]+" 2-2 on")
                        GPIO.output(LED2_2, GPIO.HIGH)
                        flag=1
                elif row[i][8]==3:
                    if row[i][9]==1:
                        print(station[j]+" 3-1 on")
                        GPIO.output(LED3_1, GPIO.HIGH)
                        flag=1
                    else:
                        print(station[j]+" 3-2 on")
                        GPIO.output(LED3_2, GPIO.HIGH)
                        flag=1
                elif row[i][8]==4:
                    if row[i][9]==1:
                        print(station[j]+" 4-1 on")
                        GPIO.output(LED4_1, GPIO.HIGH)
                        flag=1
                    else:
                        print(station[j]+" 4-2 on")
                        GPIO.output(LED4_2, GPIO.HIGH)
                        flag=1
                elif row[i][8]==5:
                    if row[i][9]==1:
                        print(station[j]+" 5-1 on")
                        GPIO.output(LED5_1, GPIO.HIGH)
                        flag=1
                    else:
                        print(station[j]+" 5-2 on")
                        GPIO.output(LED5_2, GPIO.HIGH)
                        flag=1
                elif row[i][8]==6:
                    if row[i][9]==1:
                        print(station[j]+" 6-1 on")
                        GPIO.output(LED6_1, GPIO.HIGH)
                        flag=1
                    else:
                        print(station[j]+" 6-2 on")
                        GPIO.output(LED6_2, GPIO.HIGH)
                        flag=1
                        
            elif row[i][3]==j:
                if row[i][8]==1:
                    if row[i][9]==1:
                        print(station[j]+" 1-1 off")
                        GPIO.output(LED1_1, GPIO.LOW)
                        curs.execute("delete from reservation where id = %s",row[i][0])
                        conn.commit()
                        flag=1
                    else:
                        print(station[j]+" 1-2 off")
                        GPIO.output(LED1_2, GPIO.LOW)
                        curs.execute("delete from reservation where id = %s",row[i][0])
                        conn.commit()
                        flag=1
                elif row[i][8]==2:
                    if row[i][9]==1:
                        print(station[j]+" 2-1 off")
                        GPIO.output(LED2_1, GPIO.LOW)
                        curs.execute("delete from reservation where id = %s",row[i][0])
                        conn.commit()
                        flag=1
                    else:
                        print(station[j]+" 2-2 off")
                        GPIO.output(LED2_2, GPIO.LOW)
                        curs.execute("delete from reservation where id = %s",row[i][0])
                        conn.commit()
                        flag=1
                elif row[i][8]==3:
                    if row[i][9]==1:
                        print(station[j]+" 3-1 off")
                        GPIO.output(LED3_1, GPIO.LOW)
                        curs.execute("delete from reservation where id = %s",row[i][0])
                        conn.commit()
                        flag=1
                    else:
                        print(station[j]+" 3-2 off")
                        GPIO.output(LED3_2, GPIO.LOW)
                        curs.execute("delete from reservation where id = %s",row[i][0])
                        conn.commit()
                        flag=1
                elif row[i][8]==4:
                    if row[i][9]==1:
                        print(station[j]+" 4-1 off")
                        GPIO.output(LED4_1, GPIO.LOW)
                        curs.execute("delete from reservation where id = %s",row[i][0])
                        flag=1
                    else:
                        print(station[j]+" 4-2 off")
                        GPIO.output(LED4_2, GPIO.LOW)
                        curs.execute("delete from reservation where id = %s",row[i][0])
                        flag=1
                elif row[i][8]==5:
                    if row[i][9]==1:
                        print(station[j]+" 5-1 off")
                        GPIO.output(LED5_1, GPIO.LOW)
                        curs.execute("delete from reservation where id = %s",row[i][0])
                        flag=1
                    else:
                        print(station[j]+" 5-2 off")
                        GPIO.output(LED5_2, GPIO.LOW)
                        curs.execute("delete from reservation where id = %s",row[i][0])
                        flag=1
                elif row[i][8]==6:
                    if row[i][9]==1:
                        print(station[j]+" 6-1 off")
                        GPIO.output(LED6_1, GPIO.LOW)
                        curs.execute("delete from reservation where id = %s",row[i][0])
                        flag=1
                    else:
                        print(station[j]+" 6-2 off")
                        GPIO.output(LED6_2, GPIO.LOW)
                        curs.execute("delete from reservation where id = %s",row[i][0])
                        flag=1
                        
        if flag!=1:
            print(station[j])
        time.sleep(1)
        j=j+1
        flag=0
        if j==29:
            break



    conn.close()
except KeyboardInterrupt:
        pass
GPIO.cleanup()