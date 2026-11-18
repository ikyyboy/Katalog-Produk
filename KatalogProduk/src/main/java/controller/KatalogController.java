package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import data.ProdukRepository;
import model.Produk;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;
import javafx.scene.layout.HBox;


public class KatalogController {

    @FXML
    private TextField namaField;
    @FXML
    private TextField hargaField;
    @FXML
    private ComboBox<String> fotoBox;
    @FXML
    private Label pesanLabel;
    @FXML
    private Label jumlahLabel;
    @FXML
    private TilePane katalogPane;
    @FXML
    private Button updateButton;
    @FXML
    private Button cancelButton;
    private long selectedProductId = -1;
    private final ProdukRepository repository = new ProdukRepository();

    @FXML
    private void initialize() {
        fotoBox.getItems().add("roti.png");
        fotoBox.getItems().add("susu.png");
        fotoBox.getItems().add("kopi.png");
        fotoBox.setValue("roti.png");
        updateButton.setDisable(true);
        cancelButton.setDisable(true);
        try {
            showData();
        } catch (SQLException e) {
            pesanLabel.setText("Gagal membaca database. Lihat Output.");
            e.printStackTrace();
        }
    }

    private void editProduct(Produk produk) {

    selectedProductId = produk.getId();

    namaField.setText(produk.getNama());

    hargaField.setText(
        String.valueOf(produk.getHarga())
    );

    fotoBox.setValue(produk.getFoto());

    updateButton.setDisable(false);
    cancelButton.setDisable(false);

    pesanLabel.setText(
        "Sedang mengedit produk ID: " + selectedProductId
    );
}
    
    @FXML
private void updateProduct() {

    if (selectedProductId == -1) {
        pesanLabel.setText("Pilih produk yang ingin diubah.");
        return;
    }

    try {

        String nama = namaField.getText();

        long harga = Long.parseLong(
            hargaField.getText().trim()
        );

        String foto = fotoBox.getValue();

        Produk produk = new Produk(
            selectedProductId,
            nama,
            harga,
            foto
        );

        repository.update(produk);

        clearForm();

        showData();

        pesanLabel.setText(
            "Produk berhasil diperbarui."
        );

    } catch (NumberFormatException e) {

        pesanLabel.setText(
            "Harga harus berupa angka bulat."
        );

    } catch (IllegalArgumentException e) {

        pesanLabel.setText(e.getMessage());

    } catch (SQLException e) {

        pesanLabel.setText(
            "Gagal memperbarui produk."
        );

        e.printStackTrace();
    }
}
private void deleteProduct(Produk produk) {

    Alert konfirmasi = new Alert(
        Alert.AlertType.CONFIRMATION
    );

    konfirmasi.setTitle("Konfirmasi Hapus");
    konfirmasi.setHeaderText("Hapus Produk?");
    konfirmasi.setContentText(
        "Apakah kamu yakin ingin menghapus produk "
        + produk.getNama() + "?"
    );

    Optional<ButtonType> hasil = konfirmasi.showAndWait();

    if (hasil.isPresent()
            && hasil.get() == ButtonType.OK) {

        try {

            repository.delete(produk.getId());

            if (selectedProductId == produk.getId()) {
                clearForm();
            }

            showData();

            pesanLabel.setText(
                "Produk berhasil dihapus."
            );

        } catch (SQLException e) {

            pesanLabel.setText(
                "Gagal menghapus produk."
            );

            e.printStackTrace();
        }
    }
}
private void clearForm() {

    selectedProductId = -1;

    namaField.clear();
    hargaField.clear();

    fotoBox.setValue("roti.png");

    updateButton.setDisable(true);
    cancelButton.setDisable(true);
}
@FXML
private void cancelEdit() {

    clearForm();

    pesanLabel.setText(
        "Proses edit dibatalkan."
    );
}
    private void showData() throws SQLException {
        ArrayList<Produk> daftar = repository.getAll();
        katalogPane.getChildren().clear();
        for (Produk produk : daftar) {
            VBox kartu = createProductCard(produk);
            katalogPane.getChildren().add(kartu);
        }
        jumlahLabel.setText("Jumlah produk: " + daftar.size());
    }

  
        private VBox createProductCard(Produk produk) {

    ImageView fotoView = new ImageView();

    fotoView.setFitWidth(170);
    fotoView.setFitHeight(110);
    fotoView.setPreserveRatio(true);

    StackPane bingkai = new StackPane();

    bingkai.setPrefSize(180, 120);
    bingkai.setMinSize(180, 120);
    bingkai.setMaxSize(180, 120);

    URL lokasi = getClass().getResource(
        "/image/" + produk.getFoto()
    );

    if (lokasi != null) {

        Image gambar = new Image(
            lokasi.toExternalForm(),
            170, 110, true, true
        );

        if (!gambar.isError()) {

            fotoView.setImage(gambar);
            bingkai.getChildren().add(fotoView);

        } else {

            bingkai.getChildren().add(
                new Label("Gambar tidak terbaca")
            );
        }

    } else {

        bingkai.getChildren().add(
            new Label("Gambar tidak tersedia")
        );
    }

    Label namaLabel = new Label(produk.getNama());
    namaLabel.setWrapText(true);
    namaLabel.getStyleClass().add("nama-produk");

    Label hargaLabel = new Label(
        "Rp" + produk.getHarga()
    );

    Label idLabel = new Label(
        "ID: " + produk.getId()
    );

    idLabel.getStyleClass().add("muted");

    // Tombol Edit
    Button editButton = new Button("Edit");

    editButton.setOnAction(event -> {
        editProduct(produk);
    });

    // Tombol Hapus
    Button deleteButton = new Button("Hapus");

    deleteButton.setOnAction(event -> {
        deleteProduct(produk);
    });

    // Tempat tombol
    HBox tombolPane = new HBox(8);

    tombolPane.getChildren().addAll(
        editButton,
        deleteButton
    );

    // Membuat kartu
    VBox kartu = new VBox();

    kartu.setSpacing(8);
    kartu.setMinWidth(220);
    kartu.setPrefWidth(220);
    kartu.setMaxWidth(220);

    kartu.getStyleClass().add("kartu-produk");

    kartu.getChildren().addAll(
        bingkai,
        namaLabel,
        hargaLabel,
        idLabel,
        tombolPane
    );

    return kartu;
}
   

    @FXML
    private void saveProduct() {
        Produk produk;
        try {
            String nama = namaField.getText();
            long harga = Long.parseLong(hargaField.getText().trim());
            String foto = fotoBox.getValue();
            produk = new Produk(nama, harga, foto);
        } catch (NumberFormatException e) {
            pesanLabel.setText("Harga harus angka bulat, contoh 12000.");
            return;
        } catch (IllegalArgumentException e) {
            pesanLabel.setText(e.getMessage());
            return;
        }
        try {
            repository.add(produk);
        } catch (SQLException e) {
            pesanLabel.setText("Gagal menyimpan. Lihat Output.");
            e.printStackTrace();
            return;
        }
        namaField.clear();
        hargaField.clear();
        try {
            showData();
            pesanLabel.setText("Produk berhasil disimpan.");
        } catch (SQLException e) {
            pesanLabel.setText("Data tersimpan, tetapi katalog gagal dimuat ulang.");
            e.printStackTrace();
        }
    }
}
