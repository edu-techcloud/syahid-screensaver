# Panduan Pasang Screensaver Islamik — Philips Android TV 32 inci

Projek ini membina satu fail **APK** (aplikasi) yang menjadi screensaver sebenar TV anda. Halaman screensaver (pemandangan, Bismillah, 30 hadis, solat, cuaca, monitor) sudah **terkandung dalam APK**, jadi anda tidak perlu hoskan di mana-mana.

GitHub digunakan untuk **membina APK secara percuma di awan**. Anda tidak perlu pasang Android Studio.

---

## BAHAGIAN 1 — Muat naik ke GitHub

1. Buka **github.com** dan daftar akaun percuma (atau log masuk).
2. Klik **+** (penjuru kanan atas) > **New repository**.
3. Nama: `screensaver-tv`. Pilih **Public**. Klik **Create repository**.
4. Ekstrak fail ZIP `screensaver-tv-set.zip` di komputer anda.
5. Dalam repositori baharu, klik **uploading an existing file**.
6. Seret **semua fail dan folder di dalam** folder `screensaver-tv` (bukan folder luar itu sendiri) ke halaman GitHub. Tunggu sehingga semua siap dimuat naik.
7. Tekan **Commit changes**.

**Semak folder tersembunyi `.github`:** buka tab **Code** dan pastikan ada folder `.github/workflows/build.yml`. Jika tiada (biasa berlaku di Mac atau telefon kerana folder tersembunyi):
- Klik **Add file > Create new file**.
- Dalam ruang nama, taip tepat: `.github/workflows/build.yml`
- Buka fail `build.yml` daripada ZIP, salin semua kandungannya dan tampal ke ruang besar.
- Klik **Commit changes**.

**Benarkan GitHub menulis Release:** pergi ke **Settings > Actions > General > Workflow permissions**, pilih **Read and write permissions**, kemudian **Save**.

---

## BAHAGIAN 2 — Bina APK (automatik)

1. Klik tab **Actions**. Jika ada butang hijau "I understand my workflows, enable them", tekan.
2. Anda akan nampak larian **Bina APK screensaver**. Jika tiada, klik **Bina APK screensaver > Run workflow > Run workflow**.
3. Tunggu 3 hingga 6 minit sehingga ada tanda hijau.
4. Pergi ke tab **Code**, lihat ruangan kanan **Releases**, klik **Screensaver TV v1**.
5. Di situ ada fail `screensaver-tv.apk`. Pautan tetap untuk TV:

   `https://github.com/NAMA_ANDA/screensaver-tv/releases/latest/download/screensaver-tv.apk`

   Gantikan `NAMA_ANDA` dengan nama pengguna GitHub anda. Salin pautan ini.

**Jika ada tanda merah (gagal):** klik larian itu, klik langkah yang merah dan salin 20 baris ralat terakhir. Hantar kepada saya supaya saya betulkan.

---

## BAHAGIAN 3 — Pasang di TV Philips

**A. Pasang aplikasi Downloader**
1. Di TV, buka **Google Play Store**, cari **Downloader** (oleh AFTVnews) dan pasang.

**B. Benarkan pemasangan**
2. Buka **Settings > Device Preferences > Security & restrictions > Unknown sources**.
3. Hidupkan untuk **Downloader**. (Jika diminta semasa memasang, benarkan di situ.)

**C. Muat turun dan pasang APK**
4. Buka **Downloader**, masukkan pautan dari Bahagian 2 langkah 5, tekan **Go**.
5. Selepas siap, tekan **Install**, kemudian **Done**. Anda boleh padam fail APK apabila ditanya.

**D. Jadikan screensaver**
6. Pergi ke **Settings > Device Preferences > Screen saver**.
7. Pada **Screen saver**, pilih **Screensaver Islamik**.
8. Pada **When to start**, pilih masa menunggu, contohnya 5 minit.
9. Tekan **Start now** untuk menguji.

**E. Pratonton**
10. Aplikasi **Screensaver Islamik** juga ada dalam senarai aplikasi TV. Buka untuk lihat paparan penuh tanpa menunggu.

---

## Jika "Screensaver Islamik" tiada dalam senarai Screen saver

Sesetengah TV Google TV atau Android TV terbaharu menyembunyikan screensaver pihak ketiga. Cara paksa melalui ADB (percuma, di komputer):

1. Di TV: **Settings > Device Preferences > About**, tekan **Build** 7 kali untuk hidupkan Developer options.
2. **Settings > Device Preferences > Developer options**, hidupkan **USB debugging** (atau **Network debugging**). Catat alamat IP TV (**Settings > Network**).
3. Di komputer, pasang **Android Platform Tools** (daripada developer.android.com/tools/releases/platform-tools).
4. Buka terminal atau command prompt dan taip, ganti `IP_TV`:

```
adb connect IP_TV:5555
adb shell settings put secure screensaver_components com.screensaver.tv/.WebDream
adb shell settings put secure screensaver_enabled 1
```

5. Terima kebenaran ADB yang muncul di TV, kemudian uji dengan membiarkan TV tidak disentuh.

---

## Perkara yang perlu diketahui

- **Internet diperlukan** untuk waktu solat dan cuaca. Hadis, ayat dan pemandangan tidak perlukannya.
- **Tarikh dan masa TV mesti automatik** supaya waktu solat dan pagi/malam tepat.
- Jika paparan nampak tidak cantik atau kaca tidak berkabur, kemas kini **Android System WebView** di Play Store.
- Lokasi (Melaka) boleh ditukar dalam `app/src/main/assets/index.html`, baris `var CFG = {...}`. Selepas edit di GitHub dan commit, APK akan dibina semula dan keluar sebagai Release baharu (v2, v3 dan seterusnya).
- Fon tulisan tangan dimuat turun daripada Google Fonts apabila ada internet. Jika tiada, TV guna fon sistem.
- Sila semak teks Arab dengan mushaf atau kitab hadis sebelum dipaparkan tetap.
