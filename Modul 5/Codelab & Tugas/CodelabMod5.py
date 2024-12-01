import pandas as pd

def input_nilai():
    nama = input("Masukkan Nama: ")
    nim = input("Masukkan NIM: ")
    while any(d['NIM'] == nim for d in data):
        print("NIM sudah ada, masukkan NIM yang berbeda.")
        nim = input("Masukkan NIM: ")
    semester = int(input("Masukkan Semester: "))
    mata_kuliah = input("Masukkan Mata Kuliah: ")
    nilai = float(input("Masukkan Nilai: "))
    return {'Nama': nama, 'NIM': nim, 'Semester': semester, 'Mata Kuliah': mata_kuliah, 'Nilai': nilai}

def cek_nilai(data):
    if data:
        for item in data:
            print(f"NIM: {item['NIM']}, Nama: {item['Nama']}, Semester: {item['Semester']}, Mata Kuliah: {item['Mata Kuliah']}, Nilai: {item['Nilai']}")
    else:
        print("Tidak ada data mahasiswa.")

def simpan_nilai(data):
    df = pd.DataFrame(data)
    df.to_excel('data_mahasiswa.xlsx', index=False)
    print("Data telah disimpan ke dalam file data_mahasiswa.xlsx")

def hapus_edit_nilai(data):
    nim = input("Masukkan NIM mahasiswa yang ingin diedit/dihapus: ")
    hasil = [i for i, d in enumerate(data) if d['NIM'] == nim]
    if hasil:
        print("Data ditemukan. Pilih opsi:")
        print("1. Edit")
        print("2. Hapus")
        pilihan = int(input("Masukkan pilihan: "))
        if pilihan == 1:
            index = hasil[0]
            data[index]['Nama'] = input("Masukkan Nama baru: ")
            data[index]['Semester'] = int(input("Masukkan Semester baru: "))
            data[index]['Mata Kuliah'] = input("Masukkan Mata Kuliah baru: ")
            data[index]['Nilai'] = float(input("Masukkan Nilai baru: "))
            print("Data berhasil diedit.")
        elif pilihan == 2:
            index = hasil[0]
            del data[index]
            print("Data berhasil dihapus.")
        else:
            print("Pilihan tidak valid.")
    else:
        print("Data mahasiswa tidak ditemukan.")

if __name__ == "__main__":
    try:
        df = pd.read_excel('data_mahasiswa.xlsx')
        data = df.to_dict('records')
    except FileNotFoundError:
        data = []

    while True:
        print("==Program Database Nilai Mahasiswa==")
        print("1. Input Nilai")
        print("2. Tampilkan Data")
        print("3. Simpan Nilai")
        print("4. Hapus atau Edit Nilai")
        print("5. Keluar")
        pilihan = int(input("Masukkan pilihan: "))

        if pilihan == 1:
            jumlah_mahasiswa = int(input("Masukkan jumlah mahasiswa yang akan diinput: "))
            for _ in range(jumlah_mahasiswa):
                data.append(input_nilai())
        elif pilihan == 2:
            cek_nilai(data)
        elif pilihan == 3:
            simpan_nilai(data)
        elif pilihan == 4:
            hapus_edit_nilai(data)
        elif pilihan == 5:
            break
        else:
            print("Pilihan tidak valid.")