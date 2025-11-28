📦 Sistema de Administración de Stands – Bazar Luckys Market

Aplicación desarrollada como parte del Proyecto Integrador – Computación en Java (Tecmilenio).
El sistema permite administrar vendedores, stands, reservaciones y pagos dentro de un bazar, desde una versión de consola y una interfaz gráfica (hub) desarrollada con Swing.

📸 Captura de interfaz gráfica (Hub)

(Inserta aquí una captura de la ventana HubWindow)

🎯 Objetivo del sistema

Desarrollar un sistema funcional en Java que permita:

Registrar vendedores.

Administrar stands y su disponibilidad.

Crear reservaciones validando fechas y duplicados.

Registrar y consultar pagos.

Generar reportes básicos de operación.

Ofrecer una interfaz presentable para exposición académica.

🧰 Funcionalidades principales
✔ Vendedores

Alta, edición, eliminación y listado.

Validación de datos básicos.

✔ Stands

Registro, modificación, disponibilidad (activo / inactivo).

✔ Reservaciones

Crear reservas por fecha.

Validar disponibilidad del stand.

Cancelar reservaciones.

✔ Pagos

Registrar pagos asociados a reservaciones.

Listar historiales de pagos.

✔ Reportes

Reservas por vendedor (básico).

Ingresos totales calculados automáticamente.

🖥 Formas de ejecutar el sistema
🔹 1. Versión de consola (Completa)
java com.bazar.stands.ui.Main


Ofrece toda la funcionalidad completa del sistema:
vendedores, stands, reservas, pagos y reportes.

🔹 2. Interfaz gráfica (HubWindow – Presentación)
java com.bazar.stands.ui.MainGui


Características:

Ventana diseñada para presentación profesional.

Menú visual con botones para cada módulo.

Información del proyecto y del desarrollador.

Mensajes informativos al seleccionar un módulo.

Nota: La lógica completa del negocio está implementada en la versión de consola.
La GUI funciona como un hub visual para exposición del proyecto.

🏗 Arquitectura del Proyecto
src/main/java/com/bazar/stands/
│
├── domain/          # Entidades del sistema (POJOs)
│   ├── Vendedor.java
│   ├── Stand.java
│   ├── Reservacion.java
│   ├── Pago.java
│   └── AdminUser.java
│
├── service/         # Lógica del negocio
│   ├── AuthService.java
│   ├── VendedorService.java
│   ├── StandService.java
│   ├── ReservacionService.java
│   ├── PagoService.java
│   └── ReporteService.java
│
└── ui/              # Consola y GUI
    ├── Main.java         # Versión de consola
    ├── ConsolaMenu.java  # Menú de consola
    ├── MainGui.java      # Versión gráfica
    └── HubWindow.java    # Ventana principal (hub)

🔧 Tecnologías utilizadas

Java 11+

Swing (GUI)

Programación Orientada a Objetos

IntelliJ IDEA (IDE)

Git / GitHub (control de versiones)

JUnit (opcional) para pruebas en CI

🌿 Flujo de trabajo con Git

Se utiliza una estrategia sencilla basada en ramas:

master       → versión estable del proyecto
develop      → integración continua (features completadas)
feature/*    → ramas individuales por requisito


Ejemplos de ramas:

feature/01-modelo-dominio

feature/02-modulo-stands

feature/03-reservaciones

Se recomienda:

Crear feature branch

Commit + Push

Pull Request hacia develop

Merge después de revisión

🔁 Integración Continua (Opcional)

Este proyecto puede usarse con:

Travis CI

GitHub Actions

Drone CI

Ejemplo básico con Travis (.travis.yml):

language: java
jdk:
  - openjdk11

script:
  - mvn clean test

👨‍💻 Autor

Raúl Palomino
Universidad Tecmilenio
Proyecto Integrador – Computación en Java

📄 Licencia

Proyecto académico – uso educativo.
