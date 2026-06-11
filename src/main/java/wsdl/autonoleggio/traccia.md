Si realizzi un Web Service che permette di ottenere statistiche sui noleggi di una compagnia di autonoleggio, identificata da diverse filiali (con un id univoco). I veicoli sono caratterizzati da targa, marca, modello e costo di noleggio giornaliero.

Per ogni filiale, vengono gestite le informazioni sui veicoli noleggiati e il numero totale di giorni di noleggio accumulati da ciascun veicolo in quella sede. In particolare, il servizio espone:

un metodo che, data la marca di un veicolo (es. "Fiat"), restituisce il Veicolo di quella marca che ha generato il maggior incasso totale (costo giornaliero * giorni di noleggio) calcolato su tutte le filiali.

un metodo che, dato un id filiale, restituisce una lista contenente i 2 veicoli più noleggiati (con più giorni totali) in quella specifica filiale.

come specificato nel file WSDL allegato.

<wsdl:definitions targetNamespace="http://www.examples.com/wsdl/NoleggioService">
<wsdl:types>
<schema targetNamespace="http://DefaultNamespace">
<import namespace="http://schemas.xmlsoap.org/soap/encoding/"/>

            <complexType name="Veicolo">
                <sequence>
                    <element name="targa" type="xsd:string"/>
                    <element name="marca" type="xsd:string"/>
                    <element name="modello" type="xsd:string"/>
                    <element name="costoGiornaliero" type="xsd:double"/>
                </sequence>
            </complexType>
            
            <complexType name="ListaVeicoli">
                <sequence>
                    <element name="item" type="tns1:Veicolo" maxOccurs="unbounded" minOccurs="0" />
                </sequence>
            </complexType>
        </schema>
    </wsdl:types>

    <wsdl:message name="VeicoloMaxIncassoRequest">
        <wsdl:part name="in0" type="xsd:string"/>
    </wsdl:message>
    <wsdl:message name="VeicoloMaxIncassoResponse">
        <wsdl:part name="in0" type="tns1:Veicolo"/>
    </wsdl:message>

    <wsdl:message name="TopDueVeicoliRequest">
        <wsdl:part name="in0" type="xsd:string"/>
    </wsdl:message>
    <wsdl:message name="TopDueVeicoliResponse">
        <wsdl:part name="in0" type="tns1:ListaVeicoli"/>
    </wsdl:message>

    <wsdl:portType name="NoleggioService">
        <wsdl:operation name="VeicoloMaxIncasso" parameterOrder="in0">
            <wsdl:input message="impl:VeicoloMaxIncassoRequest" name="VeicoloMaxIncassoRequest" />
            <wsdl:output message="impl:VeicoloMaxIncassoResponse" name="VeicoloMaxIncassoResponse" />
        </wsdl:operation>
        
        <wsdl:operation name="TopDueVeicoli" parameterOrder="in0">
            <wsdl:input message="impl:TopDueVeicoliRequest" name="TopDueVeicoliRequest" />
            <wsdl:output message="impl:TopDueVeicoliResponse" name="TopDueVeicoliResponse" />
        </wsdl:operation>
    </wsdl:portType>

    <wsdl:binding ...>
    ...
    </wsdl:binding>
    <wsdl:service ...>
    ...
    </wsdl:service>
</wsdl:definitions>