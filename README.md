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
