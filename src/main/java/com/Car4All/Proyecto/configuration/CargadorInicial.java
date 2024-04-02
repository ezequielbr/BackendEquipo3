//package com.Car4All.Proyecto.configuration;
//
//import com.Car4All.Proyecto.entity.*;
//import com.Car4All.Proyecto.repository.*;
//import com.Car4All.Proyecto.service.CategoriaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CargadorInicial implements ApplicationRunner {
//    @Autowired
//    private FavoritosRepository favoritosRepository;
//    @Autowired
//    private CategoriaService categoriaService;
//    @Autowired
//    private CategoriaRepository categoriaRepository;
//    @Autowired
//    private AutoRepository autoRepository;
//    @Autowired
//    private UsuarioRepository usuarioRepository;
//    @Autowired
//    private ImagenRepository imagenRepository;
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
////        BCryptPasswordEncoder cifrador = new BCryptPasswordEncoder();
////        String clave = cifrador.encode("digital");
////        System.out.println("Clave cifrada: "+cifrador);
//          Usuario usuario1= new Usuario("EzequielB","1234","ezequielbravo00@gmail.com",UsuarioRol.ROLE_ADMIN,"Ezequiel","Bravo",42711202,false);
//          Usuario usuario2= new Usuario("Nico","1234","nicoooo@gmail.com",UsuarioRol.ROLE_ADMIN,"Nicolas","Lopez",45272457,false);
//          usuarioRepository.save(usuario1);
//          usuarioRepository.save(usuario2);
//
//        Auto auto1 = new Auto("Corolla 1.8 XEI Pack CVT", "Toyota", 5, "Manual", "https://autos.hamariweb.com/images/carimages/BBCQG0U.jpg", 4, 3, 50.00);
//        autoRepository.save(auto1);
//        Auto auto2= new Auto("Cronos","Fiat",5,"Manual","https://garagem360.com.br/wp-content/uploads/2022/10/img-version-cronos-precision-13-at-2048x1306.png",4,2,55.00);
//        autoRepository.save(auto2);
//        Auto auto3= new Auto("F100","Ford",5,"Manual","https://www.pngall.com/wp-content/uploads/5/Ford-Pickup-Truck.png",4,2,45.00);
//        autoRepository.save(auto3);
//        Auto auto4= new Auto("Carrera GTS","Porche",5,"Manual","https://pluspng.com/img-png/porsche-car-png-image-2048.png",4,2,60.00);
//        autoRepository.save(auto4);
//        Auto auto5= new Auto("Cruze 1.4 LTZ AT","Chevrolet",5,"Manual","https://pngimg.com/uploads/chevrolet/%D1%81hevrolet_PNG20.png",4,2,52.00);
//        autoRepository.save(auto5);
//        Auto auto6= new Auto("Hilux SRV 3.0 TDI Aut. 4X4","Toyota",5,"Automatico","http://toyotasalinacruz.com.mx/wp-content/uploads/2020/12/toyota-hilux-exterior.png",4,2,65.00);
//        autoRepository.save(auto6);
//        Auto auto7= new Auto("Elantra 2.0 GLS","Hyundai",5,"Manual","https://pngimg.com/uploads/hyundai/hyundai_PNG11217.png",4,2,49.00);
//        autoRepository.save(auto7);
//        Auto auto8= new Auto("C 300 Kompressor","Mercedes Benz",4,"Automatico","https://pngimg.com/uploads/mercedes/mercedes_PNG1870.png",4,2,46.00);
//        autoRepository.save(auto8);
//        Auto auto9= new Auto("208 1.0 Feline CVT","Peugeot",5,"Automatica","https://www.autosphere.fr/assets/operation/LOA_208/2022-07/Peugeot-208.png",4,2,47.00);
//        autoRepository.save(auto9);
//        Auto auto10= new Auto("1500 Heavy Duty","Ram",5,"Manual","https://purepng.com/public/uploads/large/purepng.com-ram-1500-rebel-mountain-cararramvehicletransportram-truckmountain-car-961524661504ioj7u.png",4,2,53.00);
//        autoRepository.save(auto10);
//        Auto auto11= new Auto("Grand Vitara 2.0 AWD","Suzuki",5,"Manual","https://pngimg.com/uploads/pickup_truck/pickup_truck_PNG102880.png",5,4,50.00);
//        autoRepository.save(auto11);
//        Imagen imagen1 = new Imagen("https://www.megautos.com/wp-content/uploads/2017/03/Toyota-Corolla-2018-Br-interior.jpg");
//        imagenRepository.save(imagen1);
//
//        Imagen imagen2 = new Imagen("https://www.megautos.com/wp-content/uploads/2017/03/Toyota-Corolla-2018-Br-consola.jpg");
//        imagenRepository.save(imagen2);
//
//        Imagen imagen3 = new Imagen("https://www.megautos.com/wp-content/uploads/2017/03/Toyota-Corolla-2018-Br-tablero.jpg");
//        imagenRepository.save(imagen3);
//
//        Imagen imagen4 = new Imagen("https://www.megautos.com/wp-content/uploads/2017/04/Nuevo-Corolla-2017-Argentina-caja-at.jpg");
//        imagenRepository.save(imagen4);
//        Imagen imagen5 = new Imagen("https://cronos.fiat.com.ar/assets/images/img-gallery-04-full.jpg");
//        imagenRepository.save(imagen5);
//
//        Imagen imagen6 = new Imagen("https://cronos.fiat.com.ar/assets/images/img-gallery-02-full.jpg");
//        imagenRepository.save(imagen6);
//
//        Imagen imagen7 = new Imagen("https://cronos.fiat.com.ar/assets/images/img-gallery-06-full.jpg");
//        imagenRepository.save(imagen7);
//
//        Imagen imagen8 = new Imagen("https://cronos.fiat.com.ar/assets/images/img-gallery-07-full.jpg");
//        imagenRepository.save(imagen8);
//        Imagen imagen9 = new Imagen("https://ford-h.assetsadobe.com/is/image/content/dam/vdm_ford/live/en_us/ford/nameplate/f-150/2021/collections/dm/21_FRD_F15_48605.tif?croppathe=1_16x9&wid=900");
//        imagenRepository.save(imagen9);
//
//        Imagen imagen10 = new Imagen("https://www.usnews.com/cmsmedia/71/22/d4ed712d452dbe7e5b78bf5ec552/2023-ford-f-150-lightning-interior-1.jpg");
//        imagenRepository.save(imagen10);
//
//        Imagen imagen11 = new Imagen("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFD4MtMuwViPNJ0xwTDrUArGeAGtmsxgbyIxUzBpY5XLMym5mYVU3r7k8yu5ZQKRNHc-Q&usqp=CAU");
//        imagenRepository.save(imagen11);
//
//        Imagen imagen12 = new Imagen("https://es.ford.com/is/image/content/dam/vdm_ford/live/en_us/ford/nameplate/f-150f-150/2023/collections/dm/22_FRD_F15_51116_v6.tif?croppathe=1_3x2&wid=720&fit=crop&hei=480");
//        imagenRepository.save(imagen12);
//        Imagen imagen13 = new Imagen("https://pics.porsche.com/rtt/iris?COSY-EU-100-1713c6eK12UC31P3T5JOCU%25hjdmiTDDmvMXlHWguCuq6Q44RtRHo9ZAaDjYu5P3I7tGW3rNbIwNKXv9L7KcQQ%25yFN5tFAsXrw4r3wo0qnqZr8MCnR4i84tV2YN2OmNyW1QGWgCWKMUuyO8L7KMKwrhQ5YrZgfNduKyXdChQ9br3uwrD1XEUAVY8OwZoh4XP49WLrNb40zpG8rFyUv87SWQb");
//        imagenRepository.save(imagen13);
//
//        Imagen imagen14 = new Imagen("https://media.porsche.com/mediakit/911-gts/01-photos/01-01-porsche-911-gts-models/image-thumb__29519__mk2-fullsize/P21_0326_a3_rgb~-~media--a8fcb81b--query.jpg");
//        imagenRepository.save(imagen14);
//
//        Imagen imagen15 = new Imagen("https://newsroom.porsche.com/.imaging/mte/porsche-templating-theme/teaser_720x406x2/dam/pnr/2022/Products/911-GTS-Cabriolet-America-Edition/Interieur/2022_Azure_Blue_911_GTS_America_025_DSC06450.jpeg/jcr:content/2022_Azure_Blue_911_GTS_America_025_DSC06450.jpeg");
//        imagenRepository.save(imagen15);
//
//        Imagen imagen16 = new Imagen("https://files.porsche.com/filestore/galleryimagerwd/multimedia/none/992-gt3-gallery-23/zoom2/815004a8-5c9b-11eb-80d2-005056bbdc38;sL;twebp/porsche-zoom2.webp");
//        imagenRepository.save(imagen16);
//
//        Imagen imagen17 = new Imagen("https://pics.porsche.com/rtt/iris?COSY-EU-100-1713c6eK12UC31P3T5JOCU%25hjdmiTDDmvMXlHWguCuq6Q44RtRHo9ZAaDjYu5P3I7tGW3rNbIwNKXv9Z7KcQQ%25yFN5tFAsXrw4r3wo0qnqZr8MCnR4i84tV2YN2OmNyW1QGWgCWKMUuyO9V7KMYBxhQ5YCsgfNPeKyXdChQ9br3uwrD1XEUAVY1EwZoh4XP49WLrNb40zpG8rFyUv87SWQb");
//        imagenRepository.save(imagen17);
//        Imagen imagen18 = new Imagen("https://www.rutamotor.com/wp-content/uploads/2016/10/chevrolet-cruze-rutamotor-04.jpg");
//        imagenRepository.save(imagen18);
//
//        Imagen imagen19 = new Imagen("https://www.rutamotor.com/wp-content/uploads/2016/10/chevrolet-cruze-rutamotor-38.jpg");
//        imagenRepository.save(imagen19);
//
//        Imagen imagen20 = new Imagen("https://www.rutamotor.com/wp-content/uploads/2016/10/chevrolet-cruze-rutamotor-30.jpg");
//        imagenRepository.save(imagen20);
//
//        Imagen imagen21 = new Imagen("https://www.rutamotor.com/wp-content/uploads/2016/10/chevrolet-cruze-rutamotor-46.jpg");
//        imagenRepository.save(imagen21);
//        Imagen imagen22 = new Imagen("https://www.megautos.com/wp-content/uploads/2020/11/Toyota-Hilux-2021-ar-interior.jpg");
//        imagenRepository.save(imagen22);
//
//        Imagen imagen23 = new Imagen("https://www.megautos.com/wp-content/uploads/2020/11/Toyota-Hilux-2021-ar-pantalla.jpg");
//        imagenRepository.save(imagen23);
//
//        Imagen imagen24 = new Imagen("https://www.megautos.com/wp-content/uploads/2020/11/Toyota-Hilux-2021-ar-tablero.jpg");
//        imagenRepository.save(imagen24);
//
//        Imagen imagen25 = new Imagen("https://www.megautos.com/wp-content/uploads/2019/07/toyota-hilux-2020-interior-1.jpg");
//        imagenRepository.save(imagen25);
//
//        Imagen imagen26 = new Imagen("https://www.megautos.com/wp-content/uploads/2019/07/toyota-hilux-2020-interior-2.jpg");
//        imagenRepository.save(imagen26);
//        Imagen imagen27 = new Imagen("https://s7d1.scene7.com/is/image/hyundai/2024-elantra-n-line-0125-gallery:16-9?wid=1440&hei=810&qlt=85,0&fmt=webp");
//        imagenRepository.save(imagen27);
//
//        Imagen imagen28 = new Imagen("https://s7d1.scene7.com/is/image/hyundai/2024-elantra-limited-fwd-abyss-black-pearl-black-static?wid=960&qlt=85,0&fmt=webp");
//        imagenRepository.save(imagen28);
//
//        Imagen imagen29 = new Imagen("https://s7d1.scene7.com/is/image/hyundai/2024-elantra-n-line-0126-gallery:16-9?wid=1440&hei=810&qlt=85,0&fmt=webp");
//        imagenRepository.save(imagen29);
//
//        Imagen imagen30 = new Imagen("https://s7d1.scene7.com/is/image/hyundai/2024-elantra-0013-gallery:16-9?wid=1440&hei=810&qlt=85,0&fmt=webp");
//        imagenRepository.save(imagen30);
//        Imagen imagen31 = new Imagen("https://media.chromedata.com/MediaGallery/media/MjkzOTU4Xk1lZGlhIEdhbGxlcnk/NpDfsHN4uZpLNSIHSPLMWMn5SXoRz5cXace9Y1ufzpNXZWr-JclQHopdOwu80fsC37kB-cfjg9PaHcPGuL4ydZOfT_yG4_0FWQQ3iXhqcr5RCxD6DCkjpWI25UEZXrT8b_ncqyCJtI_qFdvJ9Egd5A/2024MBC890020_640_13.png");
//        imagenRepository.save(imagen31);
//
//        Imagen imagen32 = new Imagen("https://media.chromedata.com/MediaGallery/media/MjkzOTU4Xk1lZGlhIEdhbGxlcnk/NpDfsHN4uZpLNSIHSPLMWMn5SXoRz5cXace9Y1ufzpOeWx90ZMOg_Lcs2EzAHEKronlpwrUcLPZs5WcnHFMUZrr15JDgqHwmMw72fjZI6l-8F7qXc58aaIgelD_QCeJHg3S7mAo2UT183UVazQkFHw/2024MBC890018_640_11.png");
//        imagenRepository.save(imagen32);
//
//        Imagen imagen33 = new Imagen("https://media.chromedata.com/MediaGallery/media/MjkzOTU4Xk1lZGlhIEdhbGxlcnk/NpDfsHN4uZpLNSIHSPLMWMn5SXoRz5cXace9Y1ufzpPXxHBqZaH3ix3dk7crp318Y-VswMr6Q5o3Lug-Bhqvmhr9eKCOW92Ybn4cG43H5ZPEEbz7rT7zDAygEyZH4eBiI-75t__bQB_lMqMBe-ayRA/2024MBC890024_640_28.png");
//        imagenRepository.save(imagen33);
//
//        Imagen imagen34 = new Imagen("https://media.chromedata.com/MediaGallery/media/MjkzOTU4Xk1lZGlhIEdhbGxlcnk/NpDfsHN4uZpLNSIHSPLMWMn5SXoRz5cXace9Y1ufzpPihH1-g_kj4WYPfQ0-mMNeyNi-cvwRg459DThHz8yVJRWfpUAoccqx7vLhW2EpdgL3McbO1g6r1QNUtMS2Pf84vzHGTOnZJE_LC1UYk3HeKw/2024MBC890025_640_43.png");
//        imagenRepository.save(imagen34);
//
//        Imagen imagen35 = new Imagen("https://media.chromedata.com/MediaGallery/media/MjkzOTU4Xk1lZGlhIEdhbGxlcnk/NpDfsHN4uZpLNSIHSPLMWMn5SXoRz5cXace9Y1ufzpOPSKXVbI7jD-Pa60H5Kynzy104jUcoFLIVL-5gCrnZSilbn38jfunSUaAHS_yX0PW2B8RzP_pIcXUjAmi2SgYmdF-plEHKRmyk2KneTAbUfQ/2024MBC890021_640_18.png");
//        imagenRepository.save(imagen35);
//        Imagen imagen36 = new Imagen("https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjrj_maNZ8VS1705Gqu0FDrtArWprfLaIu_Twum0HP3ayWzs6NKS3LNRfZGhNvV3AUmfCTsgEbzxyz13fmX6UbtLYsiBSlcR2ehiuRaC8XlK4a4J4O4_2NTH9SbhMuQh2of0EnkEengb8o/s1024/Prueba_+Peugeot+208+Fe%25CC%2581line+1.6+Tiptronic-04-3.jpg");
//        imagenRepository.save(imagen36);
//
//        Imagen imagen37 = new Imagen("https://centraljeep.divit.com.ar/wp-content/uploads/2021/12/208-08.jpeg");
//        imagenRepository.save(imagen37);
//
//        Imagen imagen38 = new Imagen("https://sacurautos.com/wp-content/uploads/2024/01/35-_MG_2305-1024x683.jpg");
//        imagenRepository.save(imagen38);
//
//        Imagen imagen39 = new Imagen("https://sacurautos.com/wp-content/uploads/2024/01/32-_MG_2302-1024x683.jpg");
//        imagenRepository.save(imagen39);
//
//        Imagen imagen40 = new Imagen("https://sacurautos.com/wp-content/uploads/2024/01/45-_MG_2320-1024x683.jpg");
//        imagenRepository.save(imagen40);
//
//        Imagen imagen41 = new Imagen("https://www.elcarrocolombiano.com/wp-content/uploads/2018/01/20180115-RAM-1500-2019-04.jpg");
//        imagenRepository.save(imagen41);
//
//        Imagen imagen42 = new Imagen("https://www.portalautomotriz.com/sites/portalautomotriz.com/files/media/photos/ram_heavy_duty_2019_17.jpg");
//        imagenRepository.save(imagen42);
//
//        Imagen imagen43 = new Imagen("https://www.ramtrucks.com/content/dam/fca-brands/na/ramtrucks/en_us/2023/ram-1500/interior/desktop/my23-ram-1500-dt-05-interior-02-config-01.jpg.image.1440.jpg");
//        imagenRepository.save(imagen43);
//
//        Imagen imagen44 = new Imagen("https://www.motor.com.co/__export/1649791982187/sites/motor/img/2022/04/12/20220412_013301993_5c62e1325f2de.jpeg_346753400.jpeg");
//        imagenRepository.save(imagen44);
//
//        Imagen imagen45 = new Imagen("https://autozen.com.co/wp-content/uploads/2023/12/Autozen-suzuki-grand-vitara-carrusel-5.webp");
//        imagenRepository.save(imagen45);
//
//        Imagen imagen46 = new Imagen("https://autozen.com.co/wp-content/uploads/2023/12/Autozen-suzuki-gran-vitara-interior-volante.webp");
//        imagenRepository.save(imagen46);
//
//        Imagen imagen47 = new Imagen("https://autozen.com.co/wp-content/uploads/2023/12/Autozen-suzuki-gran-vitara-interior-pantalla.webp");
//        imagenRepository.save(imagen47);
//
//        Imagen imagen48 = new Imagen("https://autozen.com.co/wp-content/uploads/2023/12/Autozen-suzuki-gran-vitara-interior-maletero.webp");
//        imagenRepository.save(imagen48);
//
//        Imagen imagen49 = new Imagen("https://www.megautos.com/wp-content/uploads/2022/07/Jeep-Renegade-Longitude-2023-interior.jpg");
//        imagenRepository.save(imagen49);
//
//        Imagen imagen50 = new Imagen("https://drive.google.com/drive/u/0/folders/1ZVLyx9q9LCCTrhuiFTeYBT9MqhQ9ZULX");
//        imagenRepository.save(imagen50);
//
//        Imagen imagen51 = new Imagen("https://www.megautos.com/wp-content/uploads/2022/02/Jeep-Renegade-Longitude-2022-volante.jpg");
//        imagenRepository.save(imagen51);
//
//        Imagen imagen52 = new Imagen("https://www.megautos.com/wp-content/uploads/2022/02/Jeep-Renegade-Serie-S-2022-caja-automatica.jpg");
//        imagenRepository.save(imagen52);
//
//        Imagen imagen53 = new Imagen("https://www.megautos.com/wp-content/uploads/2022/02/Jeep-Renegade-Serie-S-2022-plazas-traseras.jpg");
//        imagenRepository.save(imagen53);
//
//        Imagen imagen54 = new Imagen("https://www.megautos.com/wp-content/uploads/2022/02/Jeep-Renegade-Longitude-2022-tablero.jpg");
//        imagenRepository.save(imagen54);
//
//        Imagen imagen55 = new Imagen("https://www.autofacil.es/wp-content/uploads/2021/04/isuzu_dmax_2021_interior.jpg");
//        imagenRepository.save(imagen55);
//
//        Imagen imagen56 = new Imagen("https://scontent.fbaq6-1.fna.fbcdn.net/v/t1.6435-9/122999988_3574457692574811_558125279338705611_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=5f2048&_nc_ohc=fzwIwz8qIbQAX8wg2bj&_nc_ht=scontent.fbaq6-1.fna&oh=00_AfA6Pa-aw8jFQV7gTTtYqKI6xscnPoNlEitGo5S0a-MfsA&oe=6630F9E2");
//        imagenRepository.save(imagen56);
//
//        Imagen imagen57 = new Imagen("https://www.deagenciapanama.com/wp-content/uploads/2021/06/Isuzu-D-Max-2022-deagenciapa.com-10.jpg");
//        imagenRepository.save(imagen57);
//
//        Imagen imagen58 = new Imagen("https://isuzusv.com/wp-content/uploads/2024/02/dmax-facelift-2023-7.jpg");
//        imagenRepository.save(imagen58);
//
//        Categoria categoria1 = new Categoria("Auto");
//        categoriaRepository.save(categoria1);
//        Categoria categoria2 = new Categoria("Camioneta");
//        categoriaRepository.save(categoria2);
//
//    }
//}
