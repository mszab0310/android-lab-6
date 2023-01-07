# android_laborator6

Dezvoltaţi o aplicaţie care citeşte de la utilizator 3 valori: 
P = o perioadă de timp (în intervalul 1-60 secunde);
V = o valoare integer (în intervalul 100-300) reprezentând un volum al sunetului generat
D = o durată de timp (în intervalul 100-1000 millisecunde) pentru sunetul generat 
Utilizatorul introduce valorile solicitate şi apoi, apăsând un buton, lansează în execuţie un serviciu care, după o 
perioadă de timp egala cu P, generează un sunet de volum V şi cu o durată egală cu D. Deoarece serviciul rulează în 
background, interfaţa cu utilizatorul trecuie să rămână activa (să nu fie blocată) iar dacă aplicaţia este închisă, serviciul 
să fie şi el închis, să nu rămână în execuţie. 
