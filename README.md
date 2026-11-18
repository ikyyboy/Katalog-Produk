# Katalog Produk - JavaFX & SQLite

Aplikasi **Katalog Produk** merupakan proyek Java berbasis desktop yang dibuat menggunakan JavaFX dan Scene Builder untuk membangun antarmuka pengguna serta SQLite sebagai database untuk menyimpan data produk.

Proyek ini dikembangkan sebagai bagian dari pembelajaran mata kuliah **Pemrograman Lanjut**, khususnya materi koneksi Java dengan database, pengelolaan data menggunakan JDBC, dan penerapan konsep pemisahan antara Model, Repository, dan Controller.

## ✨ Fitur Aplikasi

- **Tambah Produk (Create)** — Menambahkan produk baru ke dalam database.
- **Tampilkan Produk (Read)** — Menampilkan daftar produk dalam bentuk kartu katalog.
- **Edit Produk (Update)** — Mengubah informasi produk yang sudah tersimpan.
- **Hapus Produk (Delete)** — Menghapus produk dari database dengan konfirmasi.
- **Pilih Foto Produk** — Memilih gambar yang tersedia untuk produk.
- **Penyimpanan Database** — Menyimpan data menggunakan SQLite sehingga data tetap tersedia setelah aplikasi ditutup.

## 🛠️ Teknologi yang Digunakan

| Teknologi | Kegunaan |
|---|---|
| Java 17 | Bahasa pemrograman |
| JavaFX 21 | Membangun antarmuka aplikasi |
| Scene Builder | Mendesain tampilan FXML |
| SQLite | Database penyimpanan produk |
| JDBC | Menghubungkan Java dengan database |
| Maven | Mengelola dependency dan menjalankan proyek |
| CSS | Mengatur tampilan aplikasi |

## 📂 Struktur Proyek

```text
KatalogProduk/
│
├── data/
│   └── katalog.db
│
├── src/
│   └── main/
│       ├── java/
│       │   ├── main/
│       │   │   └── MainApp.java
│       │   │
│       │   ├── model/
│       │   │   └── Produk.java
│       │   │
│       │   ├── db/
│       │   │   └── Database.java
│       │   │
│       │   ├── data/
│       │   │   └── ProdukRepository.java
│       │   │
│       │   └── controller/
│       │       └── KatalogController.java
│       │
│       └── resources/
│           ├── view/
│           │   └── katalog.fxml
│           │
│           ├── styles/
│           │   └── app.css
│           │
│           └── image/
│               ├── roti.png
│               ├── susu.png
│               └── kopi.png
│
├── pom.xml
└── README.md
```
<img width="1600" height="900" alt="WhatsApp Image 2026-11-18 at 16 34 13" src="https://github.com/user-attachments/assets/7c359564-ebc1-4ae3-b77e-866d51d59916" />
<img width="1600" height="900" alt="WhatsApp Image 2026-11-18 at 16 35 19" src="https://github.com/user-attachments/assets/b295b9de-a1e9-47c9-bb3d-abec66098277" />
<img width="1600" height="900" alt="WhatsApp Image 2026-11-18 at 16 35 33" src="https://github.com/user-attachments/assets/de2c83fd-919c-4d75-8deb-4078a8ff1e09" />
<img width="1600" height="900" alt="WhatsApp Image 2026-11-18 at 16 35 43" src="https://github.com/user-attachments/assets/549ea2f2-daee-4237-abfa-3dbe63cc3499" />

## ⚙️ Cara Menjalankan Aplikasi

### 1. Persyaratan

Pastikan perangkat sudah memiliki:
- JDK 17 atau versi yang kompatibel.
- Apache NetBeans atau IDE Java lainnya.
- Maven.
- JavaFX 21 sesuai konfigurasi proyek.

### 2. Clone Repository

Buka terminal dan jalankan:

```bash
git clone https://github.com/USERNAME/KatalogProduk.git
```

Ganti `USERNAME` dengan username GitHub milikmu.

### 3. Buka Project

- Buka Apache NetBeans.
- Pilih **File → Open Project**.
- Pilih folder `KatalogProduk`.
- Tunggu hingga Maven selesai memuat dependency.

### 4. Jalankan Aplikasi

Melalui terminal, jalankan:

```bash
mvn clean javafx:run
```

Atau melalui NetBeans:
- Klik kanan project.
- Pilih **Clean and Build**.
- Klik kanan kembali.
- Pilih **Run**.

## 🗄️ Database

Aplikasi ini menggunakan SQLite sebagai media penyimpanan data.

Koneksi database dilakukan menggunakan JDBC melalui `DriverManager`. Database akan dipersiapkan oleh kelas `Database.java`, sedangkan operasi pengelolaan data
