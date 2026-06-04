Esame di Reti di Calcolatori - Prova scritta dell'11 gennaio 2023 - Seconda Parte
Esercizio 2
Si deve realizzare in Java un'applicazione di rete per la raccolta di dati da una rete di sensori distribuiti su un territorio. Il sistema e composto da tre tipologie di nodi:
- n nodi Sensori, caratterizzati da un id univoco, che inviano a intervalli prefissati un oggetto di tipo Misura contenente id del sensore, valore misurato double e timestamp di acquisizione.
- k nodi Client, che richiedono al Server informazioni sui dati raccolti dai sensori.
- 1 nodo Server, che raccoglie i dati dai sensori e gestisce le richieste dei client.
  Il Server espone i seguenti servizi:
- Socket TCP sulla porta 3000: riceve da un client una stringa con l'id di un sensore e restituisce sullo stesso socket un oggetto Misura.
- Socket UDP sulla porta 4000: riceve da un sensore un oggetto Misura e lo memorizza in una struttura dati. Ogni sensore invia una misura ogni 5 minuti.
- Un sensore e considerato non funzionante se non ha inviato misure negli ultimi 10 minuti. In questo caso il Server invia un messaggio multicast sulla porta 5000 all'indirizzo 230.0.0.1 contenente gli id dei sensori non funzionanti.
  Il Server deve gestire connessioni multiple. Si realizzino le classi e due main: uno per avviare il Server e uno per avviare un Client che si collega al Server.
