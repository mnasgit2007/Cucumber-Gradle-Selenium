# Menggunakan image dasar
FROM openjdk:17-jdk-slim

# Menetapkan direktori kerja
WORKDIR /app

# Menyalin file jar ke dalam image
COPY target/myapp.jar myapp.jar

# Menjalankan aplikasi
CMD ["java", "-jar", "myapp.jar"]
