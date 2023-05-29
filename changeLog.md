
### not Working

- bandeja de entrada implementada (falta comprobar su funcionamiento)

- la clase menuTools deja de existir y pasa a ser opcList 

- se ha implementado la clase temporal test, sirve para revisar el correcto funcionamiento del programa

- la lista empleados funciona parcialmente

- se ha creado la carpeta mensajes (punto 10 del enunciado) para almacenar los mensajes (por implementar)


### TO DO

- **IMPLEMENTAR LAS FUNCIONALIDADES PRINCIPALES DEL PROGRAMA (problema 2 y 3)**

- cuando se crea un nuevo usuario, cuando se actualiza la informacion, se borra todo el otro contenido

- en el menu: hay que cambiar la forma en la que se accede a los datos. En lugar de revisar un archivo de texto, se debe revisar por usuario

- el metodo cambiarContrasena de la clase Administrador no funciona

- falta organizar mejor el codigo

- crear diagrama UML con toda la informacion respectiva sobre el proyecto

- en la carpeta mensajes, la idea es que en esta carpeta se creen subcarpetas cada una con los archivos para almacenar la bandeja de entrada (BA), Mensajes Leidos (ML) y los Borradores (B)
  - las carpetas estaran identificadas con el numero de documento del cliente (implementar algoritmo para crear una carpeta y crear los respectivos archivos para guardar los mensajes)


### realized

- se ha añadido la clase ListaEmpleados que se encarga de almacenar la lista de los Usuarios registrados

- las clases hospedadas en "Laboratorios" estan listas 

- menu funcional, se ha eliminado algunos metodos innecesarios y se ha corregido el error que no validaba a los usuarios, ahora el login funciona correctamente

- se ha solucionado el error a la hora de imprimir los usuarios

- se ha organizado el codigo en el menu y el login (el recorrido se realiza por usuario y no se abre el archivo password como en versiones anteriores)