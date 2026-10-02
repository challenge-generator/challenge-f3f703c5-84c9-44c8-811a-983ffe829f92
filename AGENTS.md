# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Fundamentos de la Programación Orientada a Objetos**.

| | |
|---|---|
| Tema | Desarrollo de Software con OOP |
| Nivel | senior-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | capas estándar con dominio rico |
| Tiempo estimado | 2 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web 3.5.6
- org.springframework.boot:spring-boot-starter-data-jpa n/a
- org.springframework.boot:spring-boot-starter-validation n/a
- org.springframework.boot:spring-boot-starter-test n/a
- org.projectlombok:lombok 1.18.30
- com.h2database:h2 2.2.224
- org.springdoc:springdoc-openapi-starter-webmvc-ui 2.5.0

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Entender los Pilares de OOP**: Un documento que describe cada pilar de OOP, ejemplos en el contexto bancario y su contribución a la robustez del software.
- **Fase 2 — Aplicar OOP en un Sistema Bancario**: Un diagrama de clases que representa 'Cuenta Bancaria', 'Cliente' y 'Transacción', incluyendo atributos, métodos y relaciones entre clases.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/test/java/com/bank/application/CuentaServiceTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/bank/application/TransaccionServiceTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.

## Lo que falta y tenes que completar

### 1. Referencias colgando (97)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/bank/application/CuentaService.java` — `CuentaRepository.findAll`
      Se invoca `findAll` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/application/CuentaService.java` — `CuentaRepository.findByClienteId`
      Se invoca `findByClienteId` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/application/CuentaService.java` — `CuentaBancaria.getSaldo`
      Se invoca `getSaldo` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/application/CuentaService.java` — `CuentaRepository.existsById`
      Se invoca `existsById` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/application/CuentaService.java` — `CuentaRepository.deleteById`
      Se invoca `deleteById` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/application/TransaccionService.java` — `CuentaRepository.existsById`
      Se invoca `existsById` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancaria.getId`
      Se invoca `getId` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.getClienteNombre`
      Se invoca `getClienteNombre` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.getClienteApellido`
      Se invoca `getClienteApellido` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.getClienteEmail`
      Se invoca `getClienteEmail` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.getClienteFechaNacimiento`
      Se invoca `getClienteFechaNacimiento` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.getClienteNumeroIdentificacion`
      Se invoca `getClienteNumeroIdentificacion` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.getClienteTipoIdentificacion`
      Se invoca `getClienteTipoIdentificacion` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.getTipoCuenta`
      Se invoca `getTipoCuenta` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.getNumeroCuenta`
      Se invoca `getNumeroCuenta` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.getSaldo`
      Se invoca `getSaldo` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.getTasaInteres`
      Se invoca `getTasaInteres` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setId`
      Se invoca `setId` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setNumeroCuenta`
      Se invoca `setNumeroCuenta` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancaria.getNumeroCuenta`
      Se invoca `getNumeroCuenta` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setSaldo`
      Se invoca `setSaldo` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancaria.getSaldo`
      Se invoca `getSaldo` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setFechaCreacion`
      Se invoca `setFechaCreacion` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancaria.getFechaCreacion`
      Se invoca `getFechaCreacion` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setTipoCuenta`
      Se invoca `setTipoCuenta` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setTasaInteres`
      Se invoca `setTasaInteres` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaAhorro.getTasaInteres`
      Se invoca `getTasaInteres` sobre `CuentaAhorro`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancaria.getCliente`
      Se invoca `getCliente` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setClienteId`
      Se invoca `setClienteId` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `Cliente.getId`
      Se invoca `getId` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setClienteNombre`
      Se invoca `setClienteNombre` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `Cliente.getNombre`
      Se invoca `getNombre` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setClienteApellido`
      Se invoca `setClienteApellido` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `Cliente.getApellido`
      Se invoca `getApellido` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setClienteEmail`
      Se invoca `setClienteEmail` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `Cliente.getEmail`
      Se invoca `getEmail` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setClienteFechaNacimiento`
      Se invoca `setClienteFechaNacimiento` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `Cliente.getFechaNacimiento`
      Se invoca `getFechaNacimiento` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setClienteNumeroIdentificacion`
      Se invoca `setClienteNumeroIdentificacion` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `Cliente.getNumeroIdentificacion`
      Se invoca `getNumeroIdentificacion` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setClienteTipoIdentificacion`
      Se invoca `setClienteTipoIdentificacion` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `Cliente.getTipoIdentificacion`
      Se invoca `getTipoIdentificacion` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.getId`
      Se invoca `getId` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.getCuentaId`
      Se invoca `getCuentaId` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.getTipo`
      Se invoca `getTipo` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.getMonto`
      Se invoca `getMonto` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.getFecha`
      Se invoca `getFecha` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.getDescripcion`
      Se invoca `getDescripcion` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.setId`
      Se invoca `setId` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.setCuentaId`
      Se invoca `setCuentaId` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `Transaccion.getCuentaId`
      Se invoca `getCuentaId` sobre `Transaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.setTipo`
      Se invoca `setTipo` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.setMonto`
      Se invoca `setMonto` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.setFecha`
      Se invoca `setFecha` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.setDescripcion`
      Se invoca `setDescripcion` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `CuentaService.buscarPorNumero`
      Se invoca `buscarPorNumero` sobre `CuentaService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `CuentaService.realizarDeposito`
      Se invoca `realizarDeposito` sobre `CuentaService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `TransferenciaRequest.numeroCuenta`
      Se invoca `numeroCuenta` sobre `TransferenciaRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `TransferenciaRequest.monto`
      Se invoca `monto` sobre `TransferenciaRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `CuentaService.realizarRetiro`
      Se invoca `realizarRetiro` sobre `CuentaService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `CuentaService.realizarTransferencia`
      Se invoca `realizarTransferencia` sobre `CuentaService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `TransferenciaRequest.numeroCuentaOrigen`
      Se invoca `numeroCuentaOrigen` sobre `TransferenciaRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `TransferenciaRequest.numeroCuentaDestino`
      Se invoca `numeroCuentaDestino` sobre `TransferenciaRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `CuentaBancaria.getId`
      Se invoca `getId` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `CuentaBancaria.getNumeroCuenta`
      Se invoca `getNumeroCuenta` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `CuentaBancaria.getSaldo`
      Se invoca `getSaldo` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `CuentaBancaria.getFechaCreacion`
      Se invoca `getFechaCreacion` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `CuentaBancaria.getCliente`
      Se invoca `getCliente` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/controllers/TransaccionController.java` — `TransaccionService.registrarTransaccion`
      Se invoca `registrarTransaccion` sobre `TransaccionService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/controllers/TransaccionController.java` — `RetiroRequest.cuentaOrigenId`
      Se invoca `cuentaOrigenId` sobre `RetiroRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/controllers/TransaccionController.java` — `RetiroRequest.cuentaDestinoId`
      Se invoca `cuentaDestinoId` sobre `RetiroRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/controllers/TransaccionController.java` — `RetiroRequest.monto`
      Se invoca `monto` sobre `RetiroRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/controllers/TransaccionController.java` — `RetiroRequest.tipo`
      Se invoca `tipo` sobre `RetiroRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/controllers/TransaccionController.java` — `TransaccionService.obtenerTransaccionesPorCuenta`
      Se invoca `obtenerTransaccionesPorCuenta` sobre `TransaccionService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/controllers/TransaccionController.java` — `TransaccionService.obtenerTransaccionPorId`
      Se invoca `obtenerTransaccionPorId` sobre `TransaccionService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/controllers/TransaccionController.java` — `RetiroRequest.cuentaId`
      Se invoca `cuentaId` sobre `RetiroRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/controllers/TransaccionController.java` — `Transaccion.getCuentaOrigen`
      Se invoca `getCuentaOrigen` sobre `Transaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/infrastructure/controllers/TransaccionController.java` — `Transaccion.getCuentaDestino`
      Se invoca `getCuentaDestino` sobre `Transaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bank/application/CuentaServiceTest.java` — `CuentaRepository.guardar`
      Se invoca `guardar` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bank/application/CuentaServiceTest.java` — `CuentaAhorro.getSaldo`
      Se invoca `getSaldo` sobre `CuentaAhorro`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bank/application/CuentaServiceTest.java` — `CuentaRepository.buscarPorId`
      Se invoca `buscarPorId` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bank/application/CuentaServiceTest.java` — `CuentaService.obtenerCuentaPorId`
      Se invoca `obtenerCuentaPorId` sobre `CuentaService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bank/application/CuentaServiceTest.java` — `CuentaBancaria.isPresent`
      Se invoca `isPresent` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bank/application/CuentaServiceTest.java` — `CuentaAhorro.getId`
      Se invoca `getId` sobre `CuentaAhorro`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bank/application/CuentaServiceTest.java` — `CuentaBancaria.get`
      Se invoca `get` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bank/application/CuentaServiceTest.java` — `CuentaBancaria.isEmpty`
      Se invoca `isEmpty` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bank/application/CuentaServiceTest.java` — `CuentaBancaria.getSaldo`
      Se invoca `getSaldo` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bank/application/TransaccionServiceTest.java` — `CuentaRepository.buscarPorId`
      Se invoca `buscarPorId` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bank/application/TransaccionServiceTest.java` — `TransaccionRepository.guardar`
      Se invoca `guardar` sobre `TransaccionRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bank/application/TransaccionServiceTest.java` — `CuentaRepository.guardar`
      Se invoca `guardar` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bank/application/TransaccionServiceTest.java` — `TransaccionService.registrarTransaccion`
      Se invoca `registrarTransaccion` sobre `TransaccionService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bank/application/TransaccionServiceTest.java` — `TransaccionRepository.buscarPorCuenta`
      Se invoca `buscarPorCuenta` sobre `TransaccionRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bank/application/TransaccionServiceTest.java` — `TransaccionService.obtenerTransaccionesPorCuenta`
      Se invoca `obtenerTransaccionesPorCuenta` sobre `TransaccionService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bank/application/TransaccionServiceTest.java` — `TransaccionRepository.buscarPorId`
      Se invoca `buscarPorId` sobre `TransaccionRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bank/application/TransaccionServiceTest.java` — `TransaccionService.obtenerTransaccionPorId`
      Se invoca `obtenerTransaccionPorId` sobre `TransaccionService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bank/application/TransaccionServiceTest.java` — `Transaccion.isPresent`
      Se invoca `isPresent` sobre `Transaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bank/application/TransaccionServiceTest.java` — `Transaccion.get`
      Se invoca `get` sobre `Transaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (19)

- `src/main/java/com/bank/Application.java`
- `pom.xml`
- `src/main/resources/application.yml`
- `src/main/java/com/bank/domain/model/Cliente.java`
- `src/main/java/com/bank/domain/model/CuentaBancaria.java`
- `src/main/java/com/bank/domain/model/CuentaAhorro.java`
- `src/main/java/com/bank/domain/model/CuentaCorriente.java`
- `src/main/java/com/bank/domain/model/Transaccion.java`
- `src/main/java/com/bank/domain/ports/CuentaRepository.java`
- `src/main/java/com/bank/domain/ports/TransaccionRepository.java`
- `src/main/java/com/bank/application/CuentaService.java`
- `src/main/java/com/bank/application/TransaccionService.java`
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java`
- `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java`
- `src/main/java/com/bank/infrastructure/controllers/CuentaController.java`
- `src/main/java/com/bank/infrastructure/controllers/TransaccionController.java`
- `src/test/java/com/bank/application/CuentaServiceTest.java`
- `src/test/java/com/bank/application/TransaccionServiceTest.java`
- `README.md`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/bank/domain`
- `src/main/java/com/bank/domain/model`
- `src/main/java/com/bank/domain/ports`
- `src/main/java/com/bank/application`
- `src/main/java/com/bank/infrastructure/adapters`
- `src/main/java/com/bank/infrastructure/controllers`
- `src/main/resources`
- `src/test/java/com/bank`

## Verificacion

```bash
mvn clean compile
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar con dominio rico**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología Java, Senior
- Brecha que el reto ataca: Aplica los principios básicos de la programación orientada a objetos en el código (también conocida como OOP). Esto incluye los pilares de OOP, bucles, genéricos, anotaciones y más.
- Mision: Candidato con experiencia en Backend, trabajando con Java en nivel Senior

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
