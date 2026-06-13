Si realizzi un Web Service che permette di ottenere informazioni sui prodotti venduti da una catena di
magazzini, identificati da un codice (univoco) e caratterizzati da nome, produttore e prezzo di vendita. Per
ogni magazzino, identificato da un id univoco, vengono gestire le informazioni sui prodotti venduti. In
particolare, il servizio espone:
1. un metodo che, dato il nome del produttore, restituisce il Prodotto più venduto di quel produttore tra i
   diversi magazzini.
2. un metodo che, dato un id magazzino, restituisce una lista contenente i 3 prodotti che hanno prodotto
   più incassi per quel magazzino.
   come specificato nel file WSDL allegato.
   Allegato all'esercizio 4



   <wsdl:definitions targetNamespace="http://www.examples.com/wsdl/ProdottiService"> <wsdl:types>
   <schema targetNamespace="http://DefaultNamespace">
   <import namespace="http://schemas.xmlsoap.org/soap/encoding/"/>
   <complexType name="Prodotto">
   <sequence>
   <element name="codice" type="xsd:string"/>
   <element name="nome" type="xsd:string"/>
   <element name="produttore" type="xsd:string"/>
   <element name="prezzo" type="xsd:double"/>
   </sequence>
   <complexType>
   <complexType name="ListaProdotti">
   <sequence>
   <element name="item" type="tns1:Prodotto" maxOccurs="unbounded" minOccurs="0"
   </sequence>
   </complexType>
   <schema>
   <wsdl:types>
   <wsdl:message name="ProdottoPiuVendutoRequest">
   <wsdl:part name="in0" type="tns1:string"/>
   </message>
   <wsdl:message name="ProdottoPiuVendutoResponse">
   <wsdl:part name="in0" type="tns1:Prodotto"/>
   </message>
   <wsdl:message name="ProdottiMaxIncassoRequest">
   <wsdl:part name="in0" type="xsd:string"/>
   </message>
   <wsdl:message name="ProdottiMaxIncassoResponse">
   <wsdl:part name="in0" type="tnsl: Prodotto"/>
   </message>
   </wsdl:types>
   <wsdl:portType name="ProdottiService">
   <wsdl:operation name="ProdottoPiuVenduto" parameterOrder="in0">
   <wsdl:input message="impl: ProdottoPiuVendutoRequest" name=ProdottoPiuVendutoRequest />
   <wsdl:output message="impl:ProdottoPiuVendutoResponse" name=ProdottoPiuVendutoResponse /> </operation>
   <wsdl:operation name="ProdottiMaxIncasso" parameterOrder="in0">
   <wsdl:input message="impl:ProdottiMaxIncassoRequest" name=ProdottiMaxIncassoRequest />
   <wsdl:output message="impl:ProdottiMaxIncassoResponse" name=ProdottiMaxIncassoResponse /> </operation>
   </wsdl:portType>
   <wsdl:binding...>
   </wsdl:binding>
   <wsdl:service
   </wsdl:service>
   </wsdl: definitions>