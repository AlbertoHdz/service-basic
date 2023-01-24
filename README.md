# service-basic
se crea una api con metodo get y post en spring boot

Al ejecutarse el proyecto, se tiene una pagina template en la raiz

Y para acceder a los metodos se puede realizar desde una herramienta para peticiones REST
GET /api/item -> obtiene todos los elementos de una lista de objetos

POST /api/item -> Se envían los datos int uid, String nombre y descripcion tipo JSON para agregar a la lista

Para enviar los datos en el método post hay que agregar un par de headers
    Accept : application/json
    Content-Type: application/json

