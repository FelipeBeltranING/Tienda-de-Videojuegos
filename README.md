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
      entities/
      usecases/
      ui/
```
## compilacion y ejecución  
Ubíquese en la carpeta src y ejecute:
```
javac ui/Main.java
java ui.Main
```
## Pruebas

### Prueba 1 — Listar materiales
1) En el menú, elija `1`.
   
**Resultado esperado:** se listan Consola `ID: 3`, `Título: Z BOX`, `Precio: $239.99`, `Marca: MacroSoft`, `Unidades: 2`, `Disponible: true` y Videojuego `ID: 4`, `Título: God of peace`, `Precio: $19.99`, `Plataforma: PolyStation 5`,`Genero : Accion`, `Unidades: 3`, `Disponible: true`.

### Prueba 2 — Listar clientes
1) Elija `2` para ver Listado de clientes.
   
**Resultado esperado:** se listan Cliente ` ID: 1`, `Nombre: Lucia`, `Email: Lucia@mail.com` y Cliente `ID: 2`, `Nombre: Felipe`, `Email: Felipe@mail.com`.

### Prueba 3 - Vender un producto disponible
1) Elija `2` para listar clientes → confirme que aparece `ID: 1` (Lucia) e `ID: 2` (Felipe).
   
2) Elija `1` para listar productos → confirme que aparece `ID: 3` (Z BOX) e `ID: 4` (God of peace).

3) Elija 3 (Vender producto) e ingrese: `ID Cliente: 1`, `ID Producto: 4`

**Resultado esperado:** `God of peace`, `id -> 4`, `Subtotal: 19.99`, `IVA: 19.0%`,` Costo total de la compra: 23.7881$`.

### Prueba 4 - Listar Transacciones
2) Elija `3` para ver Lista de transacciones.
   
**Resultado esperado:** `ID: 5`, `Fecha: 2026-03-08`, `Cliente: Lucia`, `Producto: God of peace`, `Subtotal: $19.99`, `Total: $23.7881`,

### Prueba 5 — Intentar vender un producto ya vendido
Objetivo: verificar que el sistema impide vender un producto sin unidades disponibles.
Pasos:
1)	Elija nuevamente la opción 4 (Vender producto).
	
2)	Ingrese el mismo ID de cliente y el mismo ID de producto ya vendido `ID Cliente: 1` `ID Producto: 4`.

**Resultado esperado:** "Producto no disponible"

4) Elija `3`para ver Lista de transacciones.
   
**Resultado esperado:** `ID: 5`, `Fecha: 2026-03-08`, `Cliente: Lucia`, `Producto: God of peace`, `Subtotal: $19.99`, `Total: $23.7881.`

El resultado deberia permanecer igual ya que el producto no fue posible venderlo nuevamente por falta de unidades.

## Evidencias por requisito 
### 1) Relaciones entre las clases 
#### Uso (dependency): ``usecases.TiendaVideojuegos`` usa ``usecases.CalculadoraPrecio``

- ``private final CalculadoraPrecio calculadoraPrecio;``
- ``calculadoraPrecio.calcularPrecioVenta(...)``

#### Asociación:`` entities.Transaccion`` se asocia a`` entities.Cliente y entities.Producto``

private final Cliente cliente;

private final Producto producto;

#### Agregación: ``usecases.TiendaVideojuegos`` agrega listas (ArrayList) de Producto, Transaccion, Cliente

private final ArrayList<Producto> productos = new ArrayList<>(); etc.

#### Composición: ``entities.Transaccion`` compone`` DetalleTransaccion``

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

``usecases.IdGenerator.generarId() (static)``

``usecases.Reglas ``con public`` static`` double iva

## Diagram UML
El diagrama UML correspondiente al código está en:
- ``docs/TiendaVideojuegosUML.png``
