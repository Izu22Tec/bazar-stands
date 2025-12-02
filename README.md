\# Bazar Stands – Sistema de Administración de Stands  

\*\*Proyecto Integrador – Computación en Java\*\*



---



\## 1. Resumen Ejecutivo



\*\*Bazar Stands\*\* es un sistema desarrollado en \*\*Java\*\* para administrar la operación de un bazar físico donde se alquilan stands a vendedores independientes.  



El sistema facilita:



\- Registro y administración de vendedores  

\- Control de disponibilidad de stands  

\- Creación y cancelación de reservaciones  

\- Registro de pagos  

\- Reportes de ingresos y actividad por vendedor  



El proyecto aplica arquitectura en capas, pruebas unitarias, control de versiones, integración continua y documentación formal.



---



\# 2. Tabla de Contenidos



\- \[Descripción](#3-descripción)

\- \[Problema Identificado](#4-problema-identificado)

\- \[Solución Propuesta](#5-solución-propuesta)

\- \[Arquitectura](#6-arquitectura)

\- \[Requerimientos](#7-requerimientos)

\- \[Instalación](#8-instalación)

\- \[Configuración](#9-configuración)

\- \[Uso](#10-uso)

&nbsp; - \[Manual del Usuario Final](#manual-del-usuario-final)

&nbsp; - \[Manual del Administrador](#manual-del-administrador)

\- \[Contribución](#11-contribución)

\- \[Roadmap](#12-roadmap)

\- \[Producto (Descargas y Video)](#13-producto)

\- \[Autor](#autor)



---



\#3. Descripción



El proyecto \*\*Bazar Stands\*\* digitaliza la gestión de un bazar mediante una aplicación de escritorio en Java, permitiendo:



\- CRUD de vendedores  

\- Administración de stands  

\- Reservaciones con validación  

\- Control de pagos  

\- Reportes automáticos  



---



\# 4. Problema Identificado



Los bazares suelen administrar operaciones mediante:



\- WhatsApp  

\- Hojas de cálculo  

\- Mensajes dispersos  

\- Apuntes manuales  



Esto causa:



\- Reservaciones duplicadas  

\- Pérdida de información  

\- Ingresos no registrados  

\- Falta de reportes confiables  



---



\#5. Solución Propuesta



Un sistema centralizado que:



\- Organiza la información  

\- Valida disponibilidad  

\- Registra pagos  

\- Genera reportes  

\- Reduce errores humanos  

\- Permite crecimiento hacia GUI o web en futuras versiones  



---



\# 6. Arquitectura



\### Diagrama



```

&nbsp;                        ┌──────────────────────────┐

&nbsp;                        │     Usuario / Admin                │

&nbsp;                        │     (Interfaz Consola)             │

&nbsp;                        └──────────────┬───────────┘

&nbsp;                                       │

&nbsp;                                       ▼

&nbsp;                        ┌────────────────────────────────┐

&nbsp;                        │       Aplicación Java                      │

&nbsp;                        └──────────────┬─────────────────┘

&nbsp;                                       │

&nbsp;    ┌─────────────────────┬────────────┼─────────────┬────────────────────────┐

&nbsp;    ▼                     ▼            ▼             ▼                        ▼

&nbsp;┌─────────┐        ┌───────────┐   ┌────────┐   ┌──────────────┐     ┌────────────────┐

&nbsp;│   ui       │        │  service       │   │ domain    │   │ persistence       │     │ Archivos CSV         │

&nbsp;│ Consola    │        │ Servicios      │   │Modelo     │   │ Repositorio       │     │   /db/\*.csv          │

&nbsp;└─────────┘        └───────────┘   └────────┘   └──────────────┘     └────────────────┘

```



\### Estructura



```

src/

&nbsp;├─ main/java/com/bazar/stands

&nbsp;│   ├─ domain/

&nbsp;│   ├─ service/

&nbsp;│   └─ ui/

&nbsp;└─ test/java/

```



---



\# 7. Requerimientos



| Recurso | Versión |

|--------|---------|

| Java | 14+ |

| Maven | 3.6+ |

| JUnit | 5.8.1 |

| CI/CD | Travis CI / GitHub Actions |



\### Paquetes

\- JUnit 5  

\- Maven Surefire Plugin  



\### Infraestructura

\- No requiere base de datos  

\- Persistencia opcional en CSV  



---



\# 8. Instalación



\### 1. Clonar

```sh

git clone https://github.com/Izu22Tec/bazar-stands.git

cd bazar-stands

```



\### 2. Compilar

```sh

mvn clean install

```



\### 3. Ejecutar app

```sh

mvn exec:java -Dexec.mainClass="com.bazar.stands.ui.Main"

```



\### 4. Ejecutar pruebas

```sh

mvn clean test

```



\### 5. Generar JAR

```sh

mvn package

```



---



\# 9. Configuración



\### Archivos

```

/resources/config.properties (opcional)

/db/\*.csv (si se usa persistencia)

```



\### Requisitos

\- Java en PATH  

\- Maven instalado  

\- Crear carpeta `/db` si se usa CSV  



---



\# 10. Uso



\## Manual del Usuario Final

1\. Ejecutar el programa  

2\. Seleccionar opción del menú  

3\. Registrar o consultar datos  

4\. Generar reportes  



\## Manual del Administrador

\- Gestión completa de vendedores  

\- Gestión de stands  

\- Control de reservas  

\- Control de pagos  

\- Generación de reportes  



---



\# 11. Contribución



\### Flujo



1\. Clonar:

```sh

git clone https://github.com/Izu22Tec/bazar-stands.git

```



2\. Crear branch:

```sh

git checkout -b feature/nueva-funcionalidad

```



3\. Subir cambios:

```sh

git push origin feature/nueva-funcionalidad

```



4\. Crear Pull Request  

5\. Esperar revisión  

6\. Merge a `develop` o `master`  



---



\# 12. Roadmap



\- GUI completa Swing/JavaFX  

\- Migración a BD real  

\- Roles y permisos  

\- Dashboard web  

\- API REST  

\- Reportes PDF  

\- Hosting en nube  



---



\# 13. Producto



\### Video demostración

\*(Agregar cuando esté disponible)\*



\### Descarga JAR

\*(Agregar en GitHub Releases)\*



---



\# Autor



\*\*Raúl Palomino – Izu22Tec\*\*  

Proyecto Integrador – Computación en Java  

Universidad Tecmilenio  

2025



