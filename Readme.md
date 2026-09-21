# WashQueue - ระบบจัดการและจองคิวเครื่องซักผ้า

ระบบบริหารจัดการสถานะเครื่องซักผ้าและจองคิวการใช้งาน พร้อมระบบสมาชิกและการบันทึกประวัติการใช้งาน (Log System)

## สมาชิกในกลุ่มและการแบ่งหน้าที่ (Team Members & Roles)

1. **กฤตเมธ สุวรรณตันหยง (6821600899)** - `Front-End (Dashboard UI)`
   - ออกแบบและพัฒนาหน้าต่าง GUI หลัก (Main Dashboard) 
   - จัดการแสดงผลอัปเดตสถานะเครื่องซัก/อบ (ว่าง / กำลังทำงาน / รอคิว) แบบ Real-time
2. **ณัฐดนัย แซ่ลิ้ม (6821601003)** - `Front-End (Reservation & Authentication UI)`
   - พัฒนา GUI ระบบสมัครสมาชิก (Register) และเข้าสู่ระบบ (Login)
   - พัฒนาหน้าต่าง Pop-up สำหรับเลือกโหมดเครื่องซัก/อบ และยืนยันการจองคิว
3. **นายปริวัฒน์ สุขวิจิตต์ (6821601178)** - `Data I/O & Project Manager`
   - บริหารจัดการเอกสารโครงงานและ GitHub Repository
   - พัฒนาระบบ File I/O (FileLogService, UserManager) เพื่อจัดการข้อมูลผู้ใช้และประวัติการใช้งานลงไฟล์ `.txt`
4. **นายศุภกร รุ่งสุวรรณสกุล (6821601488)** - `Core Logic & Architecture`
   - ออกแบบ Class Diagram และสถาปัตยกรรมระบบ (OOP Architecture)
   - พัฒนาระบบนับเวลาถอยหลัง (TimerThread), ระบบจัดการคิว (QueueManager) และควบคุมสถานะ (MachineController)

---

## คุณสมบัติหลักของระบบ (Key Features)

- **Machine Status Tracking:** แสดงสถานะเครื่องซักผ้า (Available, In-Use, Pending) อัปเดตทันทีเมื่อมีการจองหรือหมดเวลา
- **Queue Management:** ระบบต่อคิวและจัดการคิวผู้ใช้งาน (QueueManager)
- **Timer Thread:** ระบบประมวลผลการนับเวลาถอยหลังการทำงานของเครื่องแบบเบื้องหลัง (Background Thread)
- **User Authentication:** ระบบสมัครสมาชิกและเข้าสู่ระบบ (Login/Register) โดยบันทึกข้อมูลแบบถาวร
- **Log Service:** ระบบบันทึกประวัติการทำรายการ (Reserve, Finish, etc.) อย่างเป็นระบบ

---

## โครงสร้างข้อมูล (Data Files)

ระบบจะทำการสร้างไฟล์ข้อมูลอัตโนมัติ (Auto-generate) หากยังไม่มีไฟล์อยู่ในระบบ เพื่อป้องกันโปรแกรม Crash:
1. `users.txt` : เก็บข้อมูลสมาชิกในรูปแบบ `[Email] | [Name] | [Phone] | [Password]`
2. `queue_log.txt` : เก็บประวัติการใช้งานในรูปแบบ `[Timestamp] | Machine: [ID] | Action: [Action] | Detail: [Detail]`

---
