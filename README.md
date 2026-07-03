# Taller1-Android1-P2
Resolución del taller 1 de Android (segundo parcial).

Qué hice en este taller:

* **Creación del proyecto:** Se creó un proyecto en Android Studio llamado `Taller-1-2P` con el paquete `com.example.taller_1_2p`.
* **Interfaz de registro:** Se diseñó la pantalla principal `activity_main.xml` con el formulario "Registro de Personas", incluyendo campos de Id, Nombre y Apellido, y los botones Guardar, Actualizar, Buscar, Eliminar y Listar.
* **Base de datos:** Se implementó SQLite mediante las clases `FeedReaderContract` (definición de la tabla y columnas) y `FeedReaderDBHelper` (creación y actualización de la base de datos).
* **CRUD:** Se programaron en `MainActivity2` las operaciones de guardar, actualizar, buscar y eliminar personas usando `SQLiteDatabase`, `ContentValues` y `Cursor`.
* **Conexión vista-código:** Se conectaron los botones con sus métodos mediante el atributo `android:onClick` en el XML, siguiendo el estilo de métodos `public void Metodo(View vista)`.
* **Segunda pantalla:** Se creó la Activity `ListarActivity` con su layout `activity_listar.xml` para mostrar el listado de personas, navegando entre pantallas con `Intent`.
* **Tabla dinámica:** Se implementó la clase `DynamicTable` para construir por código la tabla de resultados (cabecera y filas) a partir de los datos leídos de la base de datos.
* **Diseño:** Se aplicó una paleta de colores en `colors.xml`, fondos redondeados con drawables (`boton_fondo`, `campo_fondo`, `tarjeta_fondo`), cabecera con color y filas alternadas en la tabla.
* **Pruebas:** Se verificó el guardado, actualización, búsqueda y eliminación de registros, el listado en la tabla dinámica y la navegación entre las dos pantallas.
