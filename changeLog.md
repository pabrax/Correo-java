
### por validar

- bandeja de entrada implementada (falta comprobar su funcionamiento)

- la clase menuTools deja de existir y pasa a ser opcList 

- se ha implementado la clase temporal test, sirve para revisar el correcto funcionamiento del programa

- la lista empleados funciona parcialmente

- se ha creado la carpeta mensajes (punto 10 del enunciado) para almacenar los mensajes (por implementar)


### por agregar/solucionar

- cuando se crea un nuevo usuario, cuando se actualiza la informacion, se borra todo el otro contenido

- en el menu: hay que cambiar la forma en la que se accede a los datos. En lugar de revisar un archivo de texto, se debe revisar por usuario

- el metodo cambiarContrasena de la clase Administrador no funciona

- falta organizar mejor el codigo

- **IMPLEMENTAR LAS FUNCIONALIDADES PRINCIPALES DEL PROGRAMA (problema 2 y 3)**

- crear diagrama UML con toda la informacion respectiva sobre el proyecto

- crear login funcional (revisar si el usuario es admin o empleado)

- Implementar las clases y sus respectivas funcionalidades: (hacen parte de proximos laboratorios)
  - BinaryTree.java
  - BST.java

- en la carpeta mensajes, la idea es que en esta carpeta se creen subcarpetas cada una con los archivos para almacenar la bandeja de entrada (BA), Mensajes Leidos (ML) y los Borradores (B)
  - las carpetas estaran identificadas con el numero de documento del cliente (implementar algoritmo para crear una carpeta y crear los respectivos archivos para guardar los mensajes)



### correcciones

- menu funcional, se ha eliminado algunos metodos innecesarios y se ha corregido el error que no validaba a los usuarios, ahora el login funciona correctamente

- se ha solucionado el error a la hora de imprimir los usuarios

- se ha corregido el metodo import, no validaba bien las contraseñas antes de asginarlas al usuario

- la bandejaEntrada ahora esta enlazada con la clase Empleado

- En Los usuarios falta por validar sus credenciales en el Import (Password.txt)

- se ha corregido un bug en el Import del menu que no guardaba en la lista a los empleados

- se ha movido el metodo Main a la clase Menu

- se ha eliminado la carpeta de problema_1, el diagrama UML queda en la carpeta fuera del proyecto

### cosas listas

- se han movido algunas clases de carpeta y se han creado otras como MenuTools, que ayuda a la correcta ejecucion del programa y para organizar el codigo

- en la clase Menu:
  - se han añadido nuevos metodos por codear y se ha implementado el Import

- se ha añadido las clases del usuario
  - Usuario
  - Fecha
  - Direccion

- se ha añadido las clases de data_structures
  - List
  - Node
  - Queue
  - Stack
  - DoubleNode.java
  - DoubleList.java