#####################################
########### Armar Entorno ###########
#####################################

SDK de Android
Eclipse
libgdx-0.9.9.zip   <-- Librería libGDX
gdx-setup-ui.jar   <-- UI para generar proyectos Eclipse/Android/libGDX de forma sencilla
ADT-22.3.0.zip	   <-- Android Development Tools, es el plugin de Android para la IDE Eclipse (se puede instalar remoto, desde una url también)

Window -> Preferences -> Android and browse to the SDK folder <-- Configuración en Eclipse, del path al SDK


#####################################
########### Codificación ############
#####################################

- La mejor es seguir el ejemplo y usar el patrón MVC 
		https://github.com/obviam/star-assault 
		http://obviam.net/index.php/getting-started-in-android-game-development-with-libgdx-create-a-working-prototype-in-a-day-tutorial-part-1/
		
		Model:
		Cada clase de los objetos (player, tiles, etc)
		
		View:
		https://github.com/obviam/star-assault/blob/master/star-assault/src/net/obviam/starassault/view/WorldRenderer.java		
		
		Controller:
		https://github.com/obviam/star-assault/blob/master/star-assault/src/net/obviam/starassault/controller/WorldController.java
		
		Screen:
		https://github.com/obviam/star-assault/blob/master/star-assault/src/net/obviam/starassault/screens/GameScreen.java
		
		
		
- Otra posibilidad es definir una clase Principal que contenga las instancias de la camara y demás objetos:
   . GameController.java --> Dibuja a Player y Map (y la colección de Map, por ejemplo Tiles), maneja la instancia de la camara 
                              y toma los imputs del usuario, actualiza posiciones (mediante un metodo "update" de cada clase)
							  Es decir, que actualice y que dibuje. 
							  Con el patrón MVC, se separa un poco la lógica teniendo una clase dedicada únicamente a dibujar 
   . Player.java 
   . Map.java
   . Tile.java		