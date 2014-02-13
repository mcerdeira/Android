#####################################
########### Armar Entorno ###########
#####################################

SDK de Android
Eclipse
libgdx-0.9.9.zip   <-- Librer�a libGDX
gdx-setup-ui.jar   <-- UI para generar proyectos Eclipse/Android/libGDX de forma sencilla
ADT-22.3.0.zip	   <-- Android Development Tools, es el plugin de Android para la IDE Eclipse (se puede instalar remoto, desde una url tambi�n)

Window -> Preferences -> Android and browse to the SDK folder <-- Configuraci�n en Eclipse, del path al SDK


#####################################
########### Codificaci�n ############
#####################################

- La mejor es seguir el ejemplo y usar el patr�n MVC 
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
		
		
		
- Otra posibilidad es definir una clase Principal que contenga las instancias de la camara y dem�s objetos:
   . GameController.java --> Dibuja a Player y Map (y la colecci�n de Map, por ejemplo Tiles), maneja la instancia de la camara 
                              y toma los imputs del usuario, actualiza posiciones (mediante un metodo "update" de cada clase)
							  Es decir, que actualice y que dibuje. 
							  Con el patr�n MVC, se separa un poco la l�gica teniendo una clase dedicada �nicamente a dibujar 
   . Player.java 
   . Map.java
   . Tile.java		