package br.com.metodoscurrency;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class metodos {
    String objson;
    money money;
    ArrayList<money> listOfMoney = new ArrayList<>();
    public void getConversor(String moeda1, String moeda2, double qnt) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/3efd577cbfe183763364e032/pair/" + moeda1 + "/" + moeda2 + "/" + qnt))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        objson = response.body();

        Gson objGson = new Gson();
        recordObj recordObj = objGson.fromJson(objson, recordObj.class);
        money = new money(recordObj);
        money.setAmmount(qnt);
        listOfMoney.add(money);
    }


    public void ListdeCodigo(){
        System.out.println("""
                Currency Code  |  Currency Name     |       Country
                ************************************************************************************
                [AED]             UAE Dirha             United Arab Emirates
                [AFN]             Afghan Afgh           Afghanistan
                [ALL]             Albanian Lek          Albania
                [AMD]             Armenian Dr           Armenia
                [ANG]             Netherlands           Netherlands Antilles
                [AOA]             Angolan Kwanza        Angola
                [ARS]             Argentine Pe          Argentina
                [AUD]             Australian Do         Australia
                [AWG]             Aruban Florin         Aruba
                [AZN]             Azerbaijani Ma        Azerbaijan
                [BAM]             Bosnia and H          Bosnia and Herzegovina
                [BBD]             Barbados Dol          Barbados
                [BDT]             Bangladeshi Ta        Bangladesh
                [BGN]             Bulgarian Lev         Bulgaria
                [BHD]             Bahraini Dina         Bahrain
                [BIF]             Burundian Fra         Burundi
                [BMD]             Bermudian Do          Bermuda
                [BND]             Brunei Dollar         Brunei
                [BOB]             Bolivian Bol          Bolivia
                [BRL]             Brazilian Rea         Brazil
                [BSD]             Bahamian Dol          Bahamas
                [BTN]             Bhutanese Ngu         Bhutan
                [BWP]             Botswana Pul          Botswana
                [BYN]             Belarusian Ru         Belarus
                [BZD]             Belize Dollar         Belize
                [CAD]             Canadian Dol          Canada
                [CDF]             Congolese Fra         Democratic Republic of the Congo
                [CHF]             Swiss Franc           Switzerland
                [CLP]             Chilean Peso          Chile
                [CNY]             Chinese Renm          China
                [COP]             Colombian Pe          Colombia
                [CRC]             Costa Rican C         Costa Rica
                [CUP]             Cuban Peso            Cuba
                [CVE]             Cape Verdean E        Cape Verde
                [CZK]             Czech Koruna          Czech Republic
                [DJF]             Djiboutian Fr         Djibouti
                [DKK]             Danish Krone          Denmark
                [DOP]             Dominican Pe          Dominican Republic
                [DZD]             Algerian Dina         Algeria
                [EGP]             Egyptian Pou          Egypt
                [ERN]             Eritrean Nakf         Eritrea
                [ETB]             Ethiopian Bir         Ethiopia
                [EUR]             Euro                  European Union
                [FJD]             Fiji Dollar           Fiji
                [FKP]             Falkland Isla         Falkland Islands
                [FOK]             Faroese Krón          Faroe Islands
                [GBP]             Pound Sterli          United Kingdom
                [GEL]             Georgian Lar          Georgia
                [GGP]             Guernsey Pou          Guernsey
                [GHS]             Ghanaian Ced          Ghana
                [GIP]             Gibraltar Pou         Gibraltar
                [GMD]             Gambian Dala          The Gambia
                [GNF]             Guinean Fran          Guinea
                [GTQ]             Guatemalan Qu         Guatemala
                [GYD]             Guyanese Dol          Guyana
                [HKD]             Hong Kong Do          Hong Kong
                [HNL]             Honduran Lem          Honduras
                [HRK]             Croatian Kun          Croatia
                [HTG]             Haitian Gour          Haiti
                [HUF]             Hungarian For         Hungary
                [IDR]             Indonesian Ru         Indonesia
                [ILS]             Israeli New S         Israel
                [IMP]             Manx Pound            Isle of Man
                [INR]             Indian Rupee          India
                [IQD]             Iraqi Dinar           Iraq
                [IRR]             Iranian Rial          Iran
                [ISK]             Icelandic Kr          Iceland
                [JEP]             Jersey Pound          Jersey
                [JMD]             Jamaican Dol          Jamaica
                [JOD]             Jordanian Din         Jordan
                [JPY]             Japanese Yen          Japan
                [KES]             Kenyan Shilli         Kenya
                [KGS]             Kyrgyzstani So        Kyrgyzstan
                [KHR]             Cambodian Rie         Cambodia
                [KID]             Kiribati Doll         Kiribati
                [KMF]             Comorian Fra          Comoros
                [KRW]             South Korean          South Korea
                [KWD]             Kuwaiti Dina          Kuwait
                [KYD]             Cayman Islan          Cayman Islands
                [KZT]             Kazakhstani T         Kazakhstan
                [LAK]             Lao Kip               Laos
                [LBP]             Lebanese Pou          Lebanon
                [LKR]             Sri Lanka Ru          Sri Lanka
                [LRD]             Liberian Dol          Liberia
                [LSL]             Lesotho Loti          Lesotho
                [LYD]             Libyan Dinar          Libya
                [MAD]             Moroccan Dir          Morocco
                [MDL]             Moldovan Leu          Moldova
                [MGA]             Malagasy Ari          Madagascar
                [MKD]             Macedonian De         North Macedonia
                [MMK]             Burmese Kyat          Myanmar
                [MNT]             Mongolian Tö          Mongolia
                [MOP]             Macanese Pat          Macau
                [MRU]             Mauritanian O         Mauritania
                [MUR]             Mauritian Rup         Mauritius
                [MVR]             Maldivian Ruf         Maldives
                [MWK]             Malawian Kwa          Malawi
                [MXN]             Mexican Peso          Mexico
                [MYR]             Malaysian Rin         Malaysia
                [MZN]             Mozambican Me         Mozambique
                [NAD]             Namibian Dol          Namibia
                [NGN]             Nigerian Nai          Nigeria
                [NIO]             Nicaraguan Có         Nicaragua
                [NOK]             Norwegian Kr          Norway
                [NPR]             Nepalese Rup          Nepal
                [NZD]             New Zealand           New Zealand
                [OMR]             Omani Rial            Oman
                [PAB]             Panamanian Ba         Panama
                [PEN]             Peruvian Sol          Peru
                [PGK]             Papua New Gui         Papua New Guinea
                [PHP]             Philippine Pe         Philippines
                [PKR]             Pakistani Rup         Pakistan
                [PLN]             Polish Złoty          Poland
                [PYG]             Paraguayan Gu         Paraguay
                [QAR]             Qatari Riyal          Qatar
                [RON]             Romanian Leu          Romania
                [RSD]             Serbian Dina          Serbia
                [RUB]             Russian Ruble         Russia
                [RWF]             Rwandan Franc         Rwanda
                [SAR]             Saudi Riyal           Saudi Arabia
                [SBD]             Solomon Islan         Solomon Islands
                [SCR]             Seychellois R         Seychelles
                [SDG]             Sudanese Pou          Sudan
                [SEK]             Swedish Kron          Sweden
                [SGD]             Singapore Do          Singapore
                [SHP]             Saint Helena          Saint Helena
                [SLE]             Sierra Leonea         Sierra Leone
                [SOS]             Somali Shilli         Somalia
                [SRD]             Surinamese Do         Suriname
                [SSP]             South Sudane          South Sudan
                [STN]             São Tomé and          São Tomé and Príncipe
                [SYP]             Syrian Pound          Syria
                [SZL]             Eswatini Lila         Eswatini
                [THB]             Thai Baht             Thailand
                [TJS]             Tajikistani So        Tajikistan
                [TMT]             Turkmenistan          Turkmenistan
                [TND]             Tunisian Din          Tunisia
                [TOP]             Tongan Paʻang         Tonga
                [TRY]             Turkish Lira          Turkey
                [TTD]             Trinidad and          Trinidad and Tobago
                [TVD]             Tuvaluan Dolla        Tuvalu
                [TWD]             New Taiwan D          Taiwan
                [TZS]             Tanzanian Sh          Tanzania
                [UAH]             Ukrainian Hry         Ukraine
                [UGX]             Ugandan Shilli        Uganda
                [USD]             United States         United States
                [UYU]             Uruguayan Pes         Uruguay
                [UZS]             Uzbekistani S         Uzbekistan
                [VES]             Venezuelan Bó         Venezuela
                [VND]             Vietnamese Đồ         Vietnam
                [VUV]             Vanuatu Vatu          Vanuatu
                [WST]             Samoan Tālā           Samoa
                [XAF]             Central Afric         CEMAC
                [XCD]             East Caribbe          Organisation of Eastern Caribbean States
                [XDR]             Special Drawi         International Monetary Fund
                [XOF]             West African          CFA
                [XPF]             CFP Franc             Collectivités d'Outre-Mer
                [YER]             Yemeni Rial           Yemen
                [ZAR]             South African         South Africa
                [ZMW]             Zambian Kwach         Zambia
                [ZWL]             Zimbabwean Do         Zimbabwe
                ************************************************************************************
                """);
    }

    public void menu() {
        System.out.println("""
                 1) - [USD] Dólar =>> Peso argentino   [ARS]
                 2) - [ARS] Peso argentino =>> Dólar   [USD]\s
                 3) - [USD] Dólar =>> Real Brasileiro  [BRL]
                 4) - [BRL] Real Brasileiro =>> Dólar  [USD]\s
                 5) - [USD] Dólar =>> Peso Colombiano  [COP]
                 6) - [COP] Peso Colombiano =>> Dólar  [USD]
                 7) - Histórico de Conversão de Moedas
                 8) - Opção escolher conversão!
                 9) - Mostra lista de meodas aceitas
                 10) - Sair!!!!
                \s""");
    }

    public void menuOne() {
        System.out.println("""
                ************************************
                Currency Converter !!!!
                ************************************
                """);
    }

    public void menuTwo() {
        if (money != null) {
            System.out.println("*******************************************************\n");
            System.out.printf("""
                    Valor: %2.2f [%s] corresponde ao valor final de =>>> %2.2f [%s]
                    %n""", money.getAmmount(), money.getBase_code(), money.getConversion_result(), money.getTarget_code());
            System.out.println("*******************************************************\n");
        } else {
            System.out.println("Erro: objeto money não foi inicializado.");
        }
    }

    public void mensagem(){
        System.out.println("Digite o valor para conversão");
    }

    @Override
    public String toString() {
        return "[" + money.getBase_code() + "]" +
                " corresponde ao valor final de =>>> " + money.getConversion_result() +
                " [" + money.getTarget_code() + "]";
    }

    public void ListOfMoney(){
        if (listOfMoney != null && !listOfMoney.isEmpty()){
            System.out.println("Histórico de Conversão de Moeda\n");
            listOfMoney.forEach(System.out::println);
        } else {
            System.out.println("\nTente converter uma meoda");
        }
    }
}
