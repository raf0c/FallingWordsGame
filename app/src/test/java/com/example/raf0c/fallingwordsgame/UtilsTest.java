package com.example.raf0c.fallingwordsgame;

import com.example.raf0c.fallingwordsgame.utils.Utils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by raf0c on 14/08/16.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 22)
public class UtilsTest {

    private static final String JSONFILE = "words.json";
    private String jsonFile;

    @Before
    public void setUp() throws Exception {

        jsonFile = Utils.readFileFromAssets(RuntimeEnvironment.application, JSONFILE);

    }

    @Test
    public void jsonFileNotNull() throws Exception {
        assertNotNull(jsonFile);
        assertEquals(jsonFile, JSON_WORDS_STRING_FILE);
    }


    private static final String JSON_WORDS_STRING_FILE = "[\n" +
            "  {\n" +
            "    \"text_eng\": \"primary school\",\n" +
            "    \"text_spa\": \"escuela primaria\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"teacher\",\n" +
            "    \"text_spa\": \"profesor / profesora\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"pupil\",\n" +
            "    \"text_spa\": \"alumno / alumna\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"holidays\",\n" +
            "    \"text_spa\": \"vacaciones \"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"class\",\n" +
            "    \"text_spa\": \"curso\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"bell\",\n" +
            "    \"text_spa\": \"timbre\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"group\",\n" +
            "    \"text_spa\": \"grupo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"exercise book\",\n" +
            "    \"text_spa\": \"cuaderno\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"quiet\",\n" +
            "    \"text_spa\": \"quieto\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"(to) answer\",\n" +
            "    \"text_spa\": \"responder\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"headteacher\",\n" +
            "    \"text_spa\": \"director del colegio / directora del colegio\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"state school\",\n" +
            "    \"text_spa\": \"colegio público\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"private school\",\n" +
            "    \"text_spa\": \"colegio privado\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"school bus\",\n" +
            "    \"text_spa\": \"autobús escolar\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"trick\",\n" +
            "    \"text_spa\": \"jugarreta\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"pair\",\n" +
            "    \"text_spa\": \"pareja\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"exercise\",\n" +
            "    \"text_spa\": \"ejercicio\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"lunch box\",\n" +
            "    \"text_spa\": \"fiambrera\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"neat\",\n" +
            "    \"text_spa\": \"ordenado\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"motivated\",\n" +
            "    \"text_spa\": \"motivado\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"ball\",\n" +
            "    \"text_spa\": \"balón\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"Monday\",\n" +
            "    \"text_spa\": \"lunes\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"Tuesday\",\n" +
            "    \"text_spa\": \"martes\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"Wednesday\",\n" +
            "    \"text_spa\": \"miércoles\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"Thursday\",\n" +
            "    \"text_spa\": \"jueves\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"Friday\",\n" +
            "    \"text_spa\": \"viernes\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"Saturday\",\n" +
            "    \"text_spa\": \"sábado\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"Sunday\",\n" +
            "    \"text_spa\": \"domingo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"countryside\",\n" +
            "    \"text_spa\": \"campo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"rural\",\n" +
            "    \"text_spa\": \"rural\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"hill\",\n" +
            "    \"text_spa\": \"colina\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"valley\",\n" +
            "    \"text_spa\": \"valle\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"farm\",\n" +
            "    \"text_spa\": \"granja\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"field\",\n" +
            "    \"text_spa\": \"campo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"pond\",\n" +
            "    \"text_spa\": \"laguna\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"forest\",\n" +
            "    \"text_spa\": \"bosque\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"hedge\",\n" +
            "    \"text_spa\": \"seto\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"rainforest\",\n" +
            "    \"text_spa\": \"selva lluviosa\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"tropics\",\n" +
            "    \"text_spa\": \"zona tropical\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"vegetation\",\n" +
            "    \"text_spa\": \"vegetación\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"branch\",\n" +
            "    \"text_spa\": \"rama\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"parasite\",\n" +
            "    \"text_spa\": \"parásito\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"species\",\n" +
            "    \"text_spa\": \"especie\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"jungle\",\n" +
            "    \"text_spa\": \"jungla\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"equator\",\n" +
            "    \"text_spa\": \"ecuador\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"dense\",\n" +
            "    \"text_spa\": \"espeso\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"humid\",\n" +
            "    \"text_spa\": \"húmedo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"rainfall\",\n" +
            "    \"text_spa\": \"precipitación \"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"forest floor\",\n" +
            "    \"text_spa\": \"suelo del bosque\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"swamp\",\n" +
            "    \"text_spa\": \"zona pantanosa\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"building\",\n" +
            "    \"text_spa\": \"edificio\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"house\",\n" +
            "    \"text_spa\": \"casa\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"station\",\n" +
            "    \"text_spa\": \"estación\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"castle\",\n" +
            "    \"text_spa\": \"castillo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"tower block\",\n" +
            "    \"text_spa\": \"edificio alto\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"hospital\",\n" +
            "    \"text_spa\": \"hospital\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"town hall\",\n" +
            "    \"text_spa\": \"ayuntamiento\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"church\",\n" +
            "    \"text_spa\": \"iglesia\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"factory\",\n" +
            "    \"text_spa\": \"fábrica\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"(to) build\",\n" +
            "    \"text_spa\": \"construir\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"warehouse\",\n" +
            "    \"text_spa\": \"almacén\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"fire station\",\n" +
            "    \"text_spa\": \"puesto de bomberos\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"emergency\",\n" +
            "    \"text_spa\": \"urgencia\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"problem\",\n" +
            "    \"text_spa\": \"problema\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"ambulance\",\n" +
            "    \"text_spa\": \"ambulancia\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"fire brigade\",\n" +
            "    \"text_spa\": \"cuerpo de bomberos\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"fire\",\n" +
            "    \"text_spa\": \"incendio\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"firefighter\",\n" +
            "    \"text_spa\": \"bombero\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"dangerous\",\n" +
            "    \"text_spa\": \"peligroso\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"ladder\",\n" +
            "    \"text_spa\": \"escalera\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"accident\",\n" +
            "    \"text_spa\": \"accidente\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"bystander\",\n" +
            "    \"text_spa\": \"curioso\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"urgent\",\n" +
            "    \"text_spa\": \"urgente\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"(to) rescue\",\n" +
            "    \"text_spa\": \"salvar\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"ocean\",\n" +
            "    \"text_spa\": \"océano\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"sea\",\n" +
            "    \"text_spa\": \"mar\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"wave\",\n" +
            "    \"text_spa\": \"ola\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"beach\",\n" +
            "    \"text_spa\": \"playa\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"rock\",\n" +
            "    \"text_spa\": \"roca\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"seaweed\",\n" +
            "    \"text_spa\": \"alga\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"island\",\n" +
            "    \"text_spa\": \"isla\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"(to) swim\",\n" +
            "    \"text_spa\": \"nadar\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"steak\",\n" +
            "    \"text_spa\": \"bistec\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"sausage\",\n" +
            "    \"text_spa\": \"salchicha\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"fish\",\n" +
            "    \"text_spa\": \"pescado\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"fat\",\n" +
            "    \"text_spa\": \"grasa\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"lean\",\n" +
            "    \"text_spa\": \"magro\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"(to) barbecue\",\n" +
            "    \"text_spa\": \"hacer una barbacoa\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"shellfish\",\n" +
            "    \"text_spa\": \"crustáceo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"lamb\",\n" +
            "    \"text_spa\": \"cordero\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"fillet\",\n" +
            "    \"text_spa\": \"filete\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"wing\",\n" +
            "    \"text_spa\": \"ala\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"seafood\",\n" +
            "    \"text_spa\": \"marisco\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"minced meat\",\n" +
            "    \"text_spa\": \"carne picada\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"salami\",\n" +
            "    \"text_spa\": \"salami\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"tender\",\n" +
            "    \"text_spa\": \"tierno\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"insurance\",\n" +
            "    \"text_spa\": \"seguro\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"ward\",\n" +
            "    \"text_spa\": \"unidad\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"medical\",\n" +
            "    \"text_spa\": \"médico\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"(to) save\",\n" +
            "    \"text_spa\": \"salvar\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"pub\",\n" +
            "    \"text_spa\": \"bar\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"cafe\",\n" +
            "    \"text_spa\": \"café\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"(to) raise one's glass\",\n" +
            "    \"text_spa\": \"brindar\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"cheers\",\n" +
            "    \"text_spa\": \"salud\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"please\",\n" +
            "    \"text_spa\": \"por favor\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"round\",\n" +
            "    \"text_spa\": \"ronda\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"bartender\",\n" +
            "    \"text_spa\": \"barman \"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"noisy\",\n" +
            "    \"text_spa\": \"ruidoso\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"(to) serve\",\n" +
            "    \"text_spa\": \"atender\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"thank you\",\n" +
            "    \"text_spa\": \"gracias\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"peanut\",\n" +
            "    \"text_spa\": \"cacahuete\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"happy hour\",\n" +
            "    \"text_spa\": \"hora feliz\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"drunk\",\n" +
            "    \"text_spa\": \"borracho\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"(to) throw out\",\n" +
            "    \"text_spa\": \"echar\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"non-alcoholic \",\n" +
            "    \"text_spa\": \"sin alcohol\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"poverty\",\n" +
            "    \"text_spa\": \"pobreza\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"crime\",\n" +
            "    \"text_spa\": \"delito\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"illegal\",\n" +
            "    \"text_spa\": \"ilegal\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"crisis\",\n" +
            "    \"text_spa\": \"crisis\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"hunger\",\n" +
            "    \"text_spa\": \"hambre\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"violence\",\n" +
            "    \"text_spa\": \"violencia\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"victim\",\n" +
            "    \"text_spa\": \"víctima\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"curtain\",\n" +
            "    \"text_spa\": \"cortina\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"carpet\",\n" +
            "    \"text_spa\": \"alfombra\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"mirror\",\n" +
            "    \"text_spa\": \"espejo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"lamp\",\n" +
            "    \"text_spa\": \"lámpara\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"picture\",\n" +
            "    \"text_spa\": \"imagen\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"clock\",\n" +
            "    \"text_spa\": \"reloj\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"cosy\",\n" +
            "    \"text_spa\": \"acogedor\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"(to) hang\",\n" +
            "    \"text_spa\": \"colgar\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"vase\",\n" +
            "    \"text_spa\": \"florero\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"cushion\",\n" +
            "    \"text_spa\": \"cojín\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"politics\",\n" +
            "    \"text_spa\": \"política\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"country\",\n" +
            "    \"text_spa\": \"país\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"democracy\",\n" +
            "    \"text_spa\": \"democracia\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"canary\",\n" +
            "    \"text_spa\": \"canario\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"penguin\",\n" +
            "    \"text_spa\": \"pingüino\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"egg\",\n" +
            "    \"text_spa\": \"huevo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"nest\",\n" +
            "    \"text_spa\": \"nido\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"crow\",\n" +
            "    \"text_spa\": \"corneja\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"wing\",\n" +
            "    \"text_spa\": \"ala\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"sparrow\",\n" +
            "    \"text_spa\": \"gorrión\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"parrot\",\n" +
            "    \"text_spa\": \"loro\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"owl\",\n" +
            "    \"text_spa\": \"lechuza\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"eagle\",\n" +
            "    \"text_spa\": \"águila\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"swan\",\n" +
            "    \"text_spa\": \"cisne\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"foot\",\n" +
            "    \"text_spa\": \"pie\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"hand\",\n" +
            "    \"text_spa\": \"mano\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"arm\",\n" +
            "    \"text_spa\": \"brazo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"head\",\n" +
            "    \"text_spa\": \"cabeza\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"finger\",\n" +
            "    \"text_spa\": \"dedo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"eyes\",\n" +
            "    \"text_spa\": \"ojos\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"face\",\n" +
            "    \"text_spa\": \"cara\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"leg\",\n" +
            "    \"text_spa\": \"pierna\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"body\",\n" +
            "    \"text_spa\": \"cuerpo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"mouth\",\n" +
            "    \"text_spa\": \"boca\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"nose\",\n" +
            "    \"text_spa\": \"nariz\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"knee\",\n" +
            "    \"text_spa\": \"rodilla\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"ear\",\n" +
            "    \"text_spa\": \"oreja\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"tooth\",\n" +
            "    \"text_spa\": \"diente\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"neck\",\n" +
            "    \"text_spa\": \"cuello\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"back\",\n" +
            "    \"text_spa\": \"espalda\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"belly\",\n" +
            "    \"text_spa\": \"barriga\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"hare\",\n" +
            "    \"text_spa\": \"liebre\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"bear\",\n" +
            "    \"text_spa\": \"oso\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"wolf\",\n" +
            "    \"text_spa\": \"lobo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"crocodile\",\n" +
            "    \"text_spa\": \"cocodrilo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"kangaroo\",\n" +
            "    \"text_spa\": \"canguro\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"snake\",\n" +
            "    \"text_spa\": \"serpiente\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"frog\",\n" +
            "    \"text_spa\": \"rana\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"squirrel\",\n" +
            "    \"text_spa\": \"ardilla\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"armadillo\",\n" +
            "    \"text_spa\": \"armadillo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"sloth\",\n" +
            "    \"text_spa\": \"perezoso\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"hippopotamus\",\n" +
            "    \"text_spa\": \"hipopótamo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"giraffe\",\n" +
            "    \"text_spa\": \"jirafa\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"hunter\",\n" +
            "    \"text_spa\": \"cazador/a\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"deer\",\n" +
            "    \"text_spa\": \"corzo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"tame\",\n" +
            "    \"text_spa\": \"manso\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"cereal\",\n" +
            "    \"text_spa\": \"cereal\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"rice\",\n" +
            "    \"text_spa\": \"arroz\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"wheat\",\n" +
            "    \"text_spa\": \"trigo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"corn\",\n" +
            "    \"text_spa\": \"maíz\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"pasta\",\n" +
            "    \"text_spa\": \"pasta\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"tableware\",\n" +
            "    \"text_spa\": \"vajilla\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"plate\",\n" +
            "    \"text_spa\": \"plato\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"knife\",\n" +
            "    \"text_spa\": \"cuchillo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"fork\",\n" +
            "    \"text_spa\": \"tenedor\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"spoon\",\n" +
            "    \"text_spa\": \"cuchara\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"glass\",\n" +
            "    \"text_spa\": \"vaso\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"bowl\",\n" +
            "    \"text_spa\": \"sopera\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"teaspoon\",\n" +
            "    \"text_spa\": \"cucharilla\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"cup\",\n" +
            "    \"text_spa\": \"taza\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"bottle\",\n" +
            "    \"text_spa\": \"botella\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"cutlery\",\n" +
            "    \"text_spa\": \"cubertería\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"tray\",\n" +
            "    \"text_spa\": \"bandeja\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"chopsticks\",\n" +
            "    \"text_spa\": \"palillos para comer\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"saucer\",\n" +
            "    \"text_spa\": \"platillo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"tablecloth\",\n" +
            "    \"text_spa\": \"mantel\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"place setting\",\n" +
            "    \"text_spa\": \"cubierto\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"china\",\n" +
            "    \"text_spa\": \"porcelana\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"literature\",\n" +
            "    \"text_spa\": \"literatura\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"book\",\n" +
            "    \"text_spa\": \"libro\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"page\",\n" +
            "    \"text_spa\": \"página\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"story\",\n" +
            "    \"text_spa\": \"historia\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"poem\",\n" +
            "    \"text_spa\": \"poema\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"fairy tale\",\n" +
            "    \"text_spa\": \"cuento\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"paperback\",\n" +
            "    \"text_spa\": \"libro de bolsillo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"fiction\",\n" +
            "    \"text_spa\": \"bellas letras\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"long\",\n" +
            "    \"text_spa\": \"largo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"(to) read\",\n" +
            "    \"text_spa\": \"leer\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"classic\",\n" +
            "    \"text_spa\": \"clásico\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"novel\",\n" +
            "    \"text_spa\": \"novela\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"genre\",\n" +
            "    \"text_spa\": \"género\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"complicated\",\n" +
            "    \"text_spa\": \"complicado\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"dance\",\n" +
            "    \"text_spa\": \"danza\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"performance\",\n" +
            "    \"text_spa\": \"presentación\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"ballet\",\n" +
            "    \"text_spa\": \"ballet\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"ballroom\",\n" +
            "    \"text_spa\": \"salón de baile\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"partner\",\n" +
            "    \"text_spa\": \"pareja\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"waltz\",\n" +
            "    \"text_spa\": \"vals\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"swing\",\n" +
            "    \"text_spa\": \"swing\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"dancer\",\n" +
            "    \"text_spa\": \"bailarín / bailarina\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"modern\",\n" +
            "    \"text_spa\": \"moderno\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"(to) dance\",\n" +
            "    \"text_spa\": \"bailar\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"emotion\",\n" +
            "    \"text_spa\": \"emoción\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"mood\",\n" +
            "    \"text_spa\": \"humor\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"happy\",\n" +
            "    \"text_spa\": \"feliz\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"sad\",\n" +
            "    \"text_spa\": \"triste\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"excited\",\n" +
            "    \"text_spa\": \"emocionado\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"joy\",\n" +
            "    \"text_spa\": \"alegría\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"love\",\n" +
            "    \"text_spa\": \"amor\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"hate\",\n" +
            "    \"text_spa\": \"odio\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"angry\",\n" +
            "    \"text_spa\": \"enfadado\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"(to) feel\",\n" +
            "    \"text_spa\": \"sentirse\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"feeling\",\n" +
            "    \"text_spa\": \"sentimiento\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"hope\",\n" +
            "    \"text_spa\": \"esperanza\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"depressed\",\n" +
            "    \"text_spa\": \"deprimido\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"sympathy\",\n" +
            "    \"text_spa\": \"compasión\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"lonely\",\n" +
            "    \"text_spa\": \"solo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"satisfied\",\n" +
            "    \"text_spa\": \"satisfecho\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"proud\",\n" +
            "    \"text_spa\": \"orgulloso\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"disappointed\",\n" +
            "    \"text_spa\": \"decepcionado\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"upset\",\n" +
            "    \"text_spa\": \"indignado\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"painting\",\n" +
            "    \"text_spa\": \"pintura\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"photography\",\n" +
            "    \"text_spa\": \"fotografía\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"gallery\",\n" +
            "    \"text_spa\": \"galería\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"photo\",\n" +
            "    \"text_spa\": \"foto\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"artist\",\n" +
            "    \"text_spa\": \"artista\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"(to) paint\",\n" +
            "    \"text_spa\": \"pintar\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"black and white\",\n" +
            "    \"text_spa\": \"blanco y negro\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"drawing\",\n" +
            "    \"text_spa\": \"dibujo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"frame\",\n" +
            "    \"text_spa\": \"marco\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"(to) hang\",\n" +
            "    \"text_spa\": \"colgar\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"portrait\",\n" +
            "    \"text_spa\": \"retrato\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"landscape\",\n" +
            "    \"text_spa\": \"paisaje\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"abstract\",\n" +
            "    \"text_spa\": \"abstracto\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"watercolour\",\n" +
            "    \"text_spa\": \"acuarela\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"oil colour\",\n" +
            "    \"text_spa\": \"óleo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"film\",\n" +
            "    \"text_spa\": \"película\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"brush\",\n" +
            "    \"text_spa\": \"pincel\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"print\",\n" +
            "    \"text_spa\": \"copia\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"contemporary art\",\n" +
            "    \"text_spa\": \"arte contemporáneo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"artistic\",\n" +
            "    \"text_spa\": \"artístico\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"adulthood\",\n" +
            "    \"text_spa\": \"edad adulta\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"adult\",\n" +
            "    \"text_spa\": \"adulto / adulta\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"woman\",\n" +
            "    \"text_spa\": \"mujer\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"man\",\n" +
            "    \"text_spa\": \"hombre\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"(to) work\",\n" +
            "    \"text_spa\": \"trabajar\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"plan\",\n" +
            "    \"text_spa\": \"plan\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"experience\",\n" +
            "    \"text_spa\": \"experiencia\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"(to) get married\",\n" +
            "    \"text_spa\": \"casarse\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"in love\",\n" +
            "    \"text_spa\": \"enamorado\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"relatives\",\n" +
            "    \"text_spa\": \"parientes\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"grandmother\",\n" +
            "    \"text_spa\": \"abuela\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"grandfather\",\n" +
            "    \"text_spa\": \"abuelo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"grandson\",\n" +
            "    \"text_spa\": \"nieto\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"granddaughter\",\n" +
            "    \"text_spa\": \"nieta\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"nephew\",\n" +
            "    \"text_spa\": \"sobrino\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"niece\",\n" +
            "    \"text_spa\": \"sobrina\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"related\",\n" +
            "    \"text_spa\": \"pariente\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"aunt\",\n" +
            "    \"text_spa\": \"tía\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"uncle\",\n" +
            "    \"text_spa\": \"tío\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"cousin\",\n" +
            "    \"text_spa\": \"primo / prima\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"parents-in-law\",\n" +
            "    \"text_spa\": \"suegros\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"great-grandparents\",\n" +
            "    \"text_spa\": \"bisabuelos\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"descendant\",\n" +
            "    \"text_spa\": \"descendiente\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"ancestor\",\n" +
            "    \"text_spa\": \"antepasado\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"distantly\",\n" +
            "    \"text_spa\": \"lejano\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"second cousin\",\n" +
            "    \"text_spa\": \"primo de segundo grado \"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"game\",\n" +
            "    \"text_spa\": \"juego\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"puzzle\",\n" +
            "    \"text_spa\": \"juego de paciencia\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"card\",\n" +
            "    \"text_spa\": \"carta\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"dice\",\n" +
            "    \"text_spa\": \"dado\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"rule\",\n" +
            "    \"text_spa\": \"regla\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"chess\",\n" +
            "    \"text_spa\": \"ajedrez\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"crossword\",\n" +
            "    \"text_spa\": \"crucigrama\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"text_eng\": \"jigsaw\",\n" +
            "    \"text_spa\": \"puzzle\"\n" +
            "  }\n" +
            "]\n";

}
