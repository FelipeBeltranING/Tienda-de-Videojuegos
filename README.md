# Tienda de Videojuegos — Mini-Proyecto POO en Java

## Laboratorio 06 — Entrega modelo

Proyecto por consola en Java con POO, refactorizado a **Arquitectura Hexagonal (Ports & Adapters)**.

---

## Estructura

```
TiendaVideojuegos/
├── README.md
├── docs/
│   └── TiendaVideojuegosUML.png
└── src/
    ├── adapters/
    │   └── console/
    │       └── App.java
    ├── entities/
    │   ├── Cliente.java
    │   ├── Consola.java
    │   ├── DetalleTransaccion.java
    │   ├── Producto.java
    │   ├── Transaccion.java
    │   ├── Transaccionable.java
    │   └── Videojuego.java
    ├── infrastructure/
    │   ├── repositories/
    │   │   ├── InMemoryClienteRepository.java
    │   │   ├── InMemoryProductoRepository.java
    │   │   └── InMemoryTransaccionRepository.java
    │   └── services/
    │       └── IdGenerator.java
    └── usecases/
        ├── dto/
        │   └── OperationResult.java
        ├── ports/
        │   ├── ClienteRepository.java
        │   ├── IdGeneratorRepository.java
        │   ├── ProductoRepository.java
        │   └── TransaccionRepository.java
        └── services/
            ├── CalculadoraPrecio.java
            ├── RegistrarClienteUseCase.java
            ├── RegistrarProductoUseCase.java
            ├── RegistrarTransaccionUseCase.java
            ├── Reglas.java
            ├── TiendaVideojuego.java
            └── VenderUseCase.java
```

---

## Compilación y ejecución

Ubíquese en la carpeta `src` y ejecute:

```bash
javac adapters/console/App.java
java adapters.console.App
```

---

## Pruebas

> **Nota:** En la V2 los IDs son alfanuméricos con prefijo de tipo:
> `U` = Usuario/Cliente, `C` = Consola, `V` = Videojuego, `T` = Transacción.
> Los contadores inician en 100, por lo que los IDs de prueba son `U100`, `U101`, `C100`, `V100`, etc.

---

### Prueba 1 — Listar productos

1. En el menú, elija `1`.

**Resultado esperado:**

```
Consola {
  ID: C100
  Título: Z BOX
  Precio: $239.99
  Marca: MacroSoft
  Unidades: 2
  Disponible: true
}
Videojuego {
  ID: V100
  Título: God of peace
  Precio: $19.99
  Plataforma: PolyStation 5
  Género: Accion
  Unidades: 3
  Disponible: true
}
```

---

### Prueba 2 — Listar clientes

1. Elija `2` para ver el listado de clientes.

**Resultado esperado:**

```
Cliente{
  ID: U100
  Nombre: Lucia
  Email: Lucia@mail.com
}
Cliente{
  ID: U101
  Nombre: Felipe
  Email: Felipe@mail.com
}
```

---

### Prueba 3 — Vender un producto disponible

1. Elija `2` para listar clientes → confirme que aparece `ID: U100` (Lucia) e `ID: U101` (Felipe).
2. Elija `1` para listar productos → confirme que aparece `ID: C100` (Z BOX) e `ID: V100` (God of peace).
3. Elija `4` (Vender producto) e ingrese:
   - `ID Cliente: U100`
   - `ID Producto: V100`

**Resultado esperado:**

```
Venta realizada -> God of peace (ID: V100)
ID Transacción: T100
Subtotal: 19.99 | IVA: 0.19
Costo total: 23.7881$
```

---

### Prueba 4 — Listar transacciones

1. Elija `3` para ver la lista de transacciones.

**Resultado esperado:**

```
Transaccion{
  ID: T100
  Fecha: 2026-03-15
  Cliente: Lucia
  Producto: God of peace
  Subtotal: $19.99
  Total: $23.7881
}
```

---

### Prueba 5 — Intentar vender un producto ya vendido

**Objetivo:** verificar que el sistema impide vender un producto no disponible.

1. Elija nuevamente la opción `4` (Vender producto).
2. Ingrese el mismo ID de cliente y producto ya vendido:
   - `ID Cliente: U100`
   - `ID Producto: V100`

**Resultado esperado:**

```
Producto no disponible.
```

3. Elija `3` para ver la lista de transacciones.

**Resultado esperado:** la lista permanece igual con solo `T100`, ya que la segunda venta fue rechazada.

---

## Evidencias por requisito

### 1) Relaciones entre clases

#### Uso (dependency)
`VenderUseCase` usa `CalculadoraPrecio`:
```java
private final CalculadoraPrecio calculadoraPrecio;
calculadoraPrecio.calcularPrecioVenta(producto.getPrecioBase(), Reglas.iva);
```

`TiendaVideojuego` usa los casos de uso:
```java
private final VenderUseCase venderUseCase;
return venderUseCase.ejecutar(idCliente, idProducto);
```

#### Asociación
`Transaccion` se asocia a `Cliente`, `Producto` y `DetalleTransaccion`:
```java
private final Cliente cliente;
private final Producto producto;
private final DetalleTransaccion detalleTransaccion;
```

#### Agregación
`TiendaVideojuego` agrega los repositorios (las listas viven fuera de la tienda):
```java
private final ClienteRepository clienteRepository;
private final ProductoRepository productoRepository;
private final TransaccionRepository transaccionRepository;
```

#### Composición
`VenderUseCase` compone `DetalleTransaccion` dentro de `Transaccion`:
```java
DetalleTransaccion detalle = new DetalleTransaccion(
    calculadoraPrecio.calcularPrecioVenta(producto.getPrecioBase(), Reglas.iva),
    producto.getPrecioBase()
);
Transaccion transaccion = new Transaccion(
    idGeneratorRepository.nextId('T'), cliente, producto, detalle
);
```

---

### 2) Visibilidad, alcance, control de acceso

- Encapsulamiento con `private` (`titulo`, `precioBase`, `cliente`, `id`...).
- `protected` para atributos compartidos por subclases: `Producto.id`, `Producto.titulo`, `Producto.disponible`.
- Constructor privado en `OperationResult` — obliga a usar los métodos estáticos `ok()` y `fail()`:
```java
private OperationResult(boolean success, String message) { ... }
public static OperationResult ok(String message) { ... }
public static OperationResult fail(String message) { ... }
```

---

### 3) Herencia

```java
Videojuego extends Producto
Consola    extends Producto
```

---

### 4) Polimorfismo

La lista `List<Producto>` en `InMemoryProductoRepository` contiene objetos `Videojuego` y `Consola`. Se invocan métodos sobrescritos: `vender()`, `estaDisponible()` y `toString()`.

---

### 5) Clases abstractas

`Producto` es `abstract` y declara `toString()` como método abstracto, obligando a `Consola` y `Videojuego` a implementarlo.

---

### 6) Interfaces

- `Transaccionable` — define el contrato `vender()` y `estaDisponible()`, implementado por `Producto`.
- `ClienteRepository`, `ProductoRepository`, `TransaccionRepository` — definen el contrato de persistencia (`save`, `findById`, `findAll`), implementados por las clases `InMemory*`.
- `IdGeneratorRepository` — define `nextId(char typeId): String`, implementado por `IdGenerator`.

---

### 7) Modificador static

`Reglas` con `public static final double iva = 0.19`.

> **Cambio respecto a V1:** `IdGenerator` ya **no** usa métodos estáticos. Ahora implementa la interfaz `IdGeneratorRepository` para permitir sustitución e inyección de dependencias.

---

## Diagrama UML

El diagrama UML correspondiente al código está en:

- `docs/TiendaVideojuegosUML.png`
