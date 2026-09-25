import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogService implements LogService {
    private String filePath;
    private static final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Constructor 1: กำหนดชื่อไฟล์เอง
    public FileLogService(String filePath) {
        this.filePath = filePath;
        initFile();
    }

    // Constructor 2: ตั้งค่าชื่อไฟล์เริ่มต้นเป็น queue_log.txt
    public FileLogService() {
        this("queue_log.txt");
    }

    // ตรวจสอบและสร้างไฟล์ให้อัตโนมัติหากยังไม่มีไฟล์
    private void initFile() {
        File file = new File(this.filePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Error: ไม่สามารถสร้างไฟล์ Log ได้ - " + e.getMessage());
        }
    }

    @Override
    public synchronized void log(String machineId, String action, String detail) {
        String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMAT);
        // รูปแบบข้อความที่จะบันทึก: [YYYY-MM-DD HH:MM:SS] | Machine: M01 | Action: RESERVE_NOW | Detail: Room 101, 30 mins
        String logLine = String.format("[%s] | Machine: %s | Action: %s | Detail: %s", 
                                        timestamp, machineId, action, detail);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(logLine);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error: ไม่สามารถบันทึก Log ลงไฟล์ได้ - " + e.getMessage());
        }
    }
}