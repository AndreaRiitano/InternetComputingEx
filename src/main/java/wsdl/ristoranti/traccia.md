Si realizzi un Web Service che permette di ottenere statistiche sugli ordini di una nota catena di ristoranti. Ogni ristorante della catena è identificato da un codice univoco (es. "RIST_MI_01"). I piatti offerti a menù sono caratterizzati da codice piatto, nome, categoria (es. "Antipasto", "Primo", "Secondo", "Dessert") e prezzo.

Per ogni ristorante, il sistema memorizza le informazioni sui piatti serviti e la quantità totale di porzioni ordinate per ciascun piatto in quella specifica sede. Il servizio espone:

Un metodo che, data la categoria di un piatto (es. "Primo"), restituisce il Piatto appartenente a quella categoria che ha generato il maggior incasso totale (prezzo * porzioni ordinate) calcolato sommando i dati di tutti i ristoranti della catena.

Un metodo che, dato l'ID di un ristorante, restituisce una lista contenente i 3 piatti più ordinati (in termini di quantità di porzioni) in quel singolo ristorante.

come specificato nel file WSDL allegato.

<wsdl:definitions targetNamespace="http://www.examples.com/wsdl/RistoranteService">
<wsdl:types>
<schema targetNamespace="http://DefaultNamespace">
<import namespace="http://schemas.xmlsoap.org/soap/encoding/"/>

            <complexType name="Piatto">
                <sequence>
                    <element name="codice" type="xsd:string"/>
                    <element name="nome" type="xsd:string"/>
                    <element name="categoria" type="xsd:string"/>
                    <element name="prezzo" type="xsd:double"/>
                </sequence>
            </complexType>
            
            <complexType name="ListaPiatti">
                <sequence>
                    <element name="item" type="tns1:Piatto" maxOccurs="unbounded" minOccurs="0" />
                </sequence>
            </complexType>
        </schema>
    </wsdl:types>

    <wsdl:message name="PiattoMaxIncassoCategoriaRequest">
        <wsdl:part name="in0" type="xsd:string"/>
    </wsdl:message>
    <wsdl:message name="PiattoMaxIncassoCategoriaResponse">
        <wsdl:part name="in0" type="tns1:Piatto"/>
    </wsdl:message>

    <wsdl:message name="TopTrePiattiRequest">
        <wsdl:part name="in0" type="xsd:string"/>
    </wsdl:message>
    <wsdl:message name="TopTrePiattiResponse">
        <wsdl:part name="in0" type="tns1:ListaPiatti"/>
    </wsdl:message>

    <wsdl:portType name="RistoranteService">
        <wsdl:operation name="PiattoMaxIncassoCategoria" parameterOrder="in0">
            <wsdl:input message="impl:PiattoMaxIncassoCategoriaRequest" name="PiattoMaxIncassoCategoriaRequest" />
            <wsdl:output message="impl:PiattoMaxIncassoCategoriaResponse" name="PiattoMaxIncassoCategoriaResponse" />
        </wsdl:operation>
        
        <wsdl:operation name="TopTrePiatti" parameterOrder="in0">
            <wsdl:input message="impl:TopTrePiattiRequest" name="TopTrePiattiRequest" />
            <wsdl:output message="impl:TopTrePiattiResponse" name="TopTrePiattiResponse" />
        </wsdl:operation>
    </wsdl:portType>

    <wsdl:binding ...>
    ...
    </wsdl:binding>
    <wsdl:service ...>
    ...
    </wsdl:service>
</wsdl:definitions>