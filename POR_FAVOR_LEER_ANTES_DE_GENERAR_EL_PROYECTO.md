Para comenzar con el proyecto debe crear una base de datos en MySQL (no llevara mucho tiempo).
Esa base de datos tiene que tener esta tabla:
CREATE TABLE IF NOT EXISTS `coordenadas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `direccion` Varchar (100) NOT NULL,
  `coordenadas` Varchar (150) NOT NULL,
  PRIMARY KEY (`id`)
)

Con eso será suficiente para guardar los datos necesarios.
A continuación, se necesitará de XAMPP ejecutar el archivo “inserter.php”
Nota: Tiene que cambiar el nombre y la contraseña de la base de datos en el archivo insertar.php para que funcione correctamente.

Por último, ejecute la aplicación “cronometro_ejemplo” en Android y disfrute del ambiente.

