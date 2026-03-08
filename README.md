# Tienda de Videojuegos(Mini-Proyecto POO en Java)
## Laboratorio 06 — Entrega modelo
Proyecto sencillo por consola en Java con POO y organizado en paquetes.
## Estructura
```
Biblioteca/
   README.md
   docs/
      UML.png
   src/
      model/
      service/
      ui/
```
## compilacion y ejecución  
Ubíquese en la carpeta src y ejecute:
```
javac ui/Main.java
java ui.Main
```
## Pruebas 
## Evidencias por requisito 
### 1) Relaciones entre las clases 
#### Uso (dependency): ``service.TiendaVideojuegos`` usa ``service.CalculadoraPrecio``

- ``private final CalculadoraPrecio calculadoraPrecio;``
- ``calculadoraPrecio.calcularPrecioVenta(...)``

#### Asociación:`` model.Transaccion`` se asocia a`` model.Cliente y model.Producto``

private final Cliente cliente;

private final Producto producto;

#### Agregación: ``service.TiendaVideojuegos`` agrega listas (ArrayList) de Producto, Transaccion, Cliente

private final ArrayList<Producto> productos = new ArrayList<>(); etc.

#### Composición: ``model.Transaccion`` compone`` DetalleTransaccion``

private final ``DetalleTransaccion detalleTransaccion``;

``detalleTransaccion`` = new`` DetalleTransaccion(producto);``

### 2) Visibilidad, alcance, control de acceso
- Encapsulamiento con private (titulo, precioBase, cliente...).
- protected para atributo compartido por subclases: ``Producto.id, Producto.titulo, Producto.disponible.``
### 3) Herencia

``Videojuego`` extends`` Producto``

``Consola`` extends`` Producto``

### 4) Polimorfismo

Lista ``ArrayList<Producto>`` contiene objetos Videojuego y Consola

Se invocan métodos sobrescritos: ``vender()`` y ``estaDisponible()``

### 5) Clases abstractas

``Producto`` es abstract y define métodos abstractos.

### 6) Interfaces

``Transaccionable`` (vender(), estaDisponible())

### 7) Modificador static

``service.IdGenerator.generarId() (static)``

``service.Reglas ``con public`` static`` double iva

## Diagram UML
El diagrama UML correspondiente al código está en:
- ``docs/TiendaVideojuegosUML.png``
