# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/test/java/com/bank/application/CuentaServiceTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/bank/application/TransaccionServiceTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/bank/application/CuentaService.java` — `CuentaRepository.findAll`: Se invoca `findAll` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/application/CuentaService.java` — `CuentaRepository.findByClienteId`: Se invoca `findByClienteId` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/application/CuentaService.java` — `CuentaBancaria.getSaldo`: Se invoca `getSaldo` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/application/CuentaService.java` — `CuentaRepository.existsById`: Se invoca `existsById` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/application/CuentaService.java` — `CuentaRepository.deleteById`: Se invoca `deleteById` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/application/TransaccionService.java` — `CuentaRepository.existsById`: Se invoca `existsById` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancaria.getId`: Se invoca `getId` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.getClienteNombre`: Se invoca `getClienteNombre` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.getClienteApellido`: Se invoca `getClienteApellido` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.getClienteEmail`: Se invoca `getClienteEmail` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.getClienteFechaNacimiento`: Se invoca `getClienteFechaNacimiento` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.getClienteNumeroIdentificacion`: Se invoca `getClienteNumeroIdentificacion` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.getClienteTipoIdentificacion`: Se invoca `getClienteTipoIdentificacion` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.getTipoCuenta`: Se invoca `getTipoCuenta` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.getNumeroCuenta`: Se invoca `getNumeroCuenta` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.getSaldo`: Se invoca `getSaldo` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.getTasaInteres`: Se invoca `getTasaInteres` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setId`: Se invoca `setId` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setNumeroCuenta`: Se invoca `setNumeroCuenta` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancaria.getNumeroCuenta`: Se invoca `getNumeroCuenta` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setSaldo`: Se invoca `setSaldo` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancaria.getSaldo`: Se invoca `getSaldo` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setFechaCreacion`: Se invoca `setFechaCreacion` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancaria.getFechaCreacion`: Se invoca `getFechaCreacion` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setTipoCuenta`: Se invoca `setTipoCuenta` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setTasaInteres`: Se invoca `setTasaInteres` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaAhorro.getTasaInteres`: Se invoca `getTasaInteres` sobre `CuentaAhorro`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancaria.getCliente`: Se invoca `getCliente` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setClienteId`: Se invoca `setClienteId` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `Cliente.getId`: Se invoca `getId` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setClienteNombre`: Se invoca `setClienteNombre` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `Cliente.getNombre`: Se invoca `getNombre` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setClienteApellido`: Se invoca `setClienteApellido` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `Cliente.getApellido`: Se invoca `getApellido` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setClienteEmail`: Se invoca `setClienteEmail` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `Cliente.getEmail`: Se invoca `getEmail` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setClienteFechaNacimiento`: Se invoca `setClienteFechaNacimiento` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `Cliente.getFechaNacimiento`: Se invoca `getFechaNacimiento` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setClienteNumeroIdentificacion`: Se invoca `setClienteNumeroIdentificacion` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `Cliente.getNumeroIdentificacion`: Se invoca `getNumeroIdentificacion` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `CuentaBancariaEntity.setClienteTipoIdentificacion`: Se invoca `setClienteTipoIdentificacion` sobre `CuentaBancariaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java` — `Cliente.getTipoIdentificacion`: Se invoca `getTipoIdentificacion` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.getId`: Se invoca `getId` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.getCuentaId`: Se invoca `getCuentaId` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.getTipo`: Se invoca `getTipo` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.getMonto`: Se invoca `getMonto` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.getFecha`: Se invoca `getFecha` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.getDescripcion`: Se invoca `getDescripcion` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.setId`: Se invoca `setId` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.setCuentaId`: Se invoca `setCuentaId` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `Transaccion.getCuentaId`: Se invoca `getCuentaId` sobre `Transaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.setTipo`: Se invoca `setTipo` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.setMonto`: Se invoca `setMonto` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.setFecha`: Se invoca `setFecha` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java` — `TransaccionEntity.setDescripcion`: Se invoca `setDescripcion` sobre `TransaccionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `CuentaService.buscarPorNumero`: Se invoca `buscarPorNumero` sobre `CuentaService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `CuentaService.realizarDeposito`: Se invoca `realizarDeposito` sobre `CuentaService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `TransferenciaRequest.numeroCuenta`: Se invoca `numeroCuenta` sobre `TransferenciaRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `TransferenciaRequest.monto`: Se invoca `monto` sobre `TransferenciaRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `CuentaService.realizarRetiro`: Se invoca `realizarRetiro` sobre `CuentaService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `CuentaService.realizarTransferencia`: Se invoca `realizarTransferencia` sobre `CuentaService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `TransferenciaRequest.numeroCuentaOrigen`: Se invoca `numeroCuentaOrigen` sobre `TransferenciaRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `TransferenciaRequest.numeroCuentaDestino`: Se invoca `numeroCuentaDestino` sobre `TransferenciaRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `CuentaBancaria.getId`: Se invoca `getId` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `CuentaBancaria.getNumeroCuenta`: Se invoca `getNumeroCuenta` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `CuentaBancaria.getSaldo`: Se invoca `getSaldo` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `CuentaBancaria.getFechaCreacion`: Se invoca `getFechaCreacion` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/controllers/CuentaController.java` — `CuentaBancaria.getCliente`: Se invoca `getCliente` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/controllers/TransaccionController.java` — `TransaccionService.registrarTransaccion`: Se invoca `registrarTransaccion` sobre `TransaccionService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/controllers/TransaccionController.java` — `RetiroRequest.cuentaOrigenId`: Se invoca `cuentaOrigenId` sobre `RetiroRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/controllers/TransaccionController.java` — `RetiroRequest.cuentaDestinoId`: Se invoca `cuentaDestinoId` sobre `RetiroRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/controllers/TransaccionController.java` — `RetiroRequest.monto`: Se invoca `monto` sobre `RetiroRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/controllers/TransaccionController.java` — `RetiroRequest.tipo`: Se invoca `tipo` sobre `RetiroRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/controllers/TransaccionController.java` — `TransaccionService.obtenerTransaccionesPorCuenta`: Se invoca `obtenerTransaccionesPorCuenta` sobre `TransaccionService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/controllers/TransaccionController.java` — `TransaccionService.obtenerTransaccionPorId`: Se invoca `obtenerTransaccionPorId` sobre `TransaccionService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/controllers/TransaccionController.java` — `RetiroRequest.cuentaId`: Se invoca `cuentaId` sobre `RetiroRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/controllers/TransaccionController.java` — `Transaccion.getCuentaOrigen`: Se invoca `getCuentaOrigen` sobre `Transaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/infrastructure/controllers/TransaccionController.java` — `Transaccion.getCuentaDestino`: Se invoca `getCuentaDestino` sobre `Transaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/application/CuentaServiceTest.java` — `CuentaRepository.guardar`: Se invoca `guardar` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/application/CuentaServiceTest.java` — `CuentaAhorro.getSaldo`: Se invoca `getSaldo` sobre `CuentaAhorro`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/application/CuentaServiceTest.java` — `CuentaRepository.buscarPorId`: Se invoca `buscarPorId` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/application/CuentaServiceTest.java` — `CuentaService.obtenerCuentaPorId`: Se invoca `obtenerCuentaPorId` sobre `CuentaService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/application/CuentaServiceTest.java` — `CuentaBancaria.isPresent`: Se invoca `isPresent` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/application/CuentaServiceTest.java` — `CuentaAhorro.getId`: Se invoca `getId` sobre `CuentaAhorro`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/application/CuentaServiceTest.java` — `CuentaBancaria.get`: Se invoca `get` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/application/CuentaServiceTest.java` — `CuentaBancaria.isEmpty`: Se invoca `isEmpty` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/application/CuentaServiceTest.java` — `CuentaBancaria.getSaldo`: Se invoca `getSaldo` sobre `CuentaBancaria`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/application/TransaccionServiceTest.java` — `CuentaRepository.buscarPorId`: Se invoca `buscarPorId` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/application/TransaccionServiceTest.java` — `TransaccionRepository.guardar`: Se invoca `guardar` sobre `TransaccionRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/application/TransaccionServiceTest.java` — `CuentaRepository.guardar`: Se invoca `guardar` sobre `CuentaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/application/TransaccionServiceTest.java` — `TransaccionService.registrarTransaccion`: Se invoca `registrarTransaccion` sobre `TransaccionService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/application/TransaccionServiceTest.java` — `TransaccionRepository.buscarPorCuenta`: Se invoca `buscarPorCuenta` sobre `TransaccionRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/application/TransaccionServiceTest.java` — `TransaccionService.obtenerTransaccionesPorCuenta`: Se invoca `obtenerTransaccionesPorCuenta` sobre `TransaccionService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/application/TransaccionServiceTest.java` — `TransaccionRepository.buscarPorId`: Se invoca `buscarPorId` sobre `TransaccionRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/application/TransaccionServiceTest.java` — `TransaccionService.obtenerTransaccionPorId`: Se invoca `obtenerTransaccionPorId` sobre `TransaccionService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/application/TransaccionServiceTest.java` — `Transaccion.isPresent`: Se invoca `isPresent` sobre `Transaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/application/TransaccionServiceTest.java` — `Transaccion.get`: Se invoca `get` sobre `Transaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Senior

### Brecha de conocimiento
Aplica los principios básicos de la programación orientada a objetos en el código (también conocida como OOP). Esto incluye los pilares de OOP, bucles, genéricos, anotaciones y más.

### Misión / candidato
Candidato con experiencia en Backend, trabajando con Java en nivel Senior

### Reto
- Tema: Desarrollo de Software con OOP
- Seniority: senior-l2
- Tipo: theoretical
- Título: Fundamentos de la Programación Orientada a Objetos
- Tiempo estimado: 2 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Entender los Pilares de OOP — objetivo: Identificar y describir los cuatro pilares de la Programación Orientada a Objetos y su importancia en el desarrollo de software. — entregable (NO resolver): Un documento que describe cada pilar de OOP, ejemplos en el contexto bancario y su contribución a la robustez del software.
- Fase 2: Aplicar OOP en un Sistema Bancario — objetivo: Diseñar clases que representen entidades bancarias aplicando los principios de OOP. — entregable (NO resolver): Un diagrama de clases que representa 'Cuenta Bancaria', 'Cliente' y 'Transacción', incluyendo atributos, métodos y relaciones entre clases.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: src/main/java/com/bank/Application.java ===
package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;

@SpringBootApplication
@EnableWebMvc
@EnableTransactionManagement
@EnableAsync
public class Application {

    private final Environment environment;

    public Application(Environment environment) {
        this.environment = environment;
        validateActiveProfiles();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        logApplicationStartup();
    }

    private void validateActiveProfiles() {
        String[] activeProfiles = environment.getActiveProfiles();
        if (activeProfiles.length == 0) {
            throw new IllegalStateException("No active Spring profile set. Please configure at least one profile (e.g., 'dev', 'prod').");
        }
    }

    private void logApplicationStartup() {
        String protocol = environment.getProperty("server.ssl.key-store") != null ? "https" : "http";
        String serverPort = environment.getProperty("server.port");
        String contextPath = environment.getProperty("server.servlet.context-path", "/");
        String hostAddress = "localhost";

        System.out.println("\n----------------------------------------------------------");
        System.out.println("Application '" + environment.getProperty("spring.application.name") + "' is running!");
        System.out.println("Access URLs:");
        System.out.println("Local:      " + protocol + "://" + hostAddress + ":" + serverPort + contextPath);
        System.out.println("Profiles:   " + Arrays.toString(environment.getActiveProfiles()));
        System.out.println("----------------------------------------------------------\n");
    }
}

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.bank</groupId>
    <artifactId>bank-system</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>bank-system</name>
    <description>Bank System with OOP principles</description>

    <properties>
        <java.version>21</java.version>
        <springdoc-openapi.version>2.5.0</springdoc-openapi.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.30</version>
            <scope>provided</scope>
        </dependency>

        <!-- Database -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>2.2.224</version>
            <scope>runtime</scope>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!-- OpenAPI -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>${springdoc-openapi.version}</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: bank-system
  profiles:
    active: dev
  datasource:
    url: jdbc:h2:mem:bankdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
    driver-class-name: org.h2.Driver
    username: sa
    password: ''
  h2:
    console:
      enabled: true
      path: /h2-console
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        use_sql_comments: true
        default_batch_fetch_size: 20
        jdbc:
          batch_size: 20
server:
  port: 8080
  servlet:
    context-path: /api
springdoc:
  api-docs:
    path: /v3/api-docs
  swagger-ui:
    path: /swagger-ui.html
    operationsSorter: method
    tagsSorter: alpha
    displayRequestDuration: true
    tryItOutEnabled: true
logging:
  level:
    org.springframework: INFO
    org.hibernate: DEBUG
    com.bank: DEBUG

// === ARCHIVO: src/main/java/com/bank/domain/model/Cliente.java ===
package com.bank.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.UUID;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private UUID id;

    @NotNull(message = "El nombre del cliente no puede ser nulo")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    @NotNull(message = "El apellido del cliente no puede ser nulo")
    @Size(min = 2, max = 100, message = "El apellido debe tener entre 2 y 100 caracteres")
    private String apellido;

    @NotNull(message = "El email del cliente no puede ser nulo")
    @Email(message = "El email debe ser válido")
    private String email;

    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    private LocalDate fechaNacimiento;

    @NotNull(message = "El número de identificación no puede ser nulo")
    @Size(min = 5, max = 20, message = "El número de identificación debe tener entre 5 y 20 caracteres")
    private String numeroIdentificacion;

    @NotNull(message = "El tipo de identificación no puede ser nulo")
    private TipoIdentificacion tipoIdentificacion;

    public enum TipoIdentificacion {
        CC, CE, PASAPORTE
    }

    public Cliente(String nombre, String apellido, String email, LocalDate fechaNacimiento,
                  String numeroIdentificacion, TipoIdentificacion tipoIdentificacion) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroIdentificacion = numeroIdentificacion;
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public int calcularEdad() {
        return LocalDate.now().getYear() - fechaNacimiento.getYear();
    }

    public boolean esMayorDeEdad() {
        return calcularEdad() >= 18;
    }
}

// === ARCHIVO: src/main/java/com/bank/domain/model/CuentaBancaria.java ===
package com.bank.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Getter
@Setter
@NoArgsConstructor
public abstract class CuentaBancaria {
    private UUID id;

    @NotNull(message = "El número de cuenta no puede ser nulo")
    private String numeroCuenta;

    @NotNull(message = "El cliente asociado no puede ser nulo")
    private Cliente cliente;

    @NotNull(message = "El saldo no puede ser nulo")
    @PositiveOrZero(message = "El saldo no puede ser negativo")
    private BigDecimal saldo;

    @NotNull(message = "La fecha de creación no puede ser nula")
    private LocalDateTime fechaCreacion;

    public CuentaBancaria(String numeroCuenta, Cliente cliente, BigDecimal saldoInicial) {
        this.id = UUID.randomUUID();
        this.numeroCuenta = numeroCuenta;
        this.cliente = cliente;
        this.saldo = saldoInicial != null ? saldoInicial : BigDecimal.ZERO;
        this.fechaCreacion = LocalDateTime.now();
    }

    public abstract void depositar(BigDecimal monto);

    public abstract void retirar(BigDecimal monto) throws SaldoInsuficienteException;

    public void transferir(CuentaBancaria destino, BigDecimal monto) throws SaldoInsuficienteException {
        if (this.equals(destino)) {
            throw new IllegalArgumentException("No se puede transferir a la misma cuenta");
        }
        this.retirar(monto);
        destino.depositar(monto);
    }

    public static class SaldoInsuficienteException extends Exception {
        public SaldoInsuficienteException(String mensaje) {
            super(mensaje);
        }
    }
}

// === ARCHIVO: src/main/java/com/bank/domain/model/CuentaAhorro.java ===
package com.bank.domain.model;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
public class CuentaAhorro extends CuentaBancaria {
    private BigDecimal tasaInteres;

    public CuentaAhorro(String numeroCuenta, Cliente cliente, BigDecimal saldoInicial, BigDecimal tasaInteres) {
        super(numeroCuenta, cliente, saldoInicial);
        this.tasaInteres = tasaInteres != null ? tasaInteres : BigDecimal.ZERO;
    }

    @Override
    public void depositar(BigDecimal monto) {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo");
        }
        this.setSaldo(this.getSaldo().add(monto));
    }

    @Override
    public void retirar(BigDecimal monto) throws SaldoInsuficienteException {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo");
        }
        if (this.getSaldo().compareTo(monto) < 0) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar el retiro");
        }
        this.setSaldo(this.getSaldo().subtract(monto));
    }

    public void aplicarInteres() {
        BigDecimal interes = this.getSaldo().multiply(tasaInteres)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        this.depositar(interes);
    }

    public BigDecimal calcularInteresMensual() {
        return this.getSaldo().multiply(tasaInteres)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }
}

// === ARCHIVO: src/main/java/com/bank/domain/model/CuentaCorriente.java ===
package com.bank.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * CuentaCorriente es una implementación concreta de CuentaBancaria.
 * Este tipo de cuenta permite sobregiro ( overdraft ) y tiene comisiones por uso.
 * Representa la aplicación de herencia y polimorfismo en el dominio bancario.
 */
public class CuentaCorriente extends CuentaBancaria {

    private BigDecimal limiteSobregiro;
    private BigDecimal comisionMensual;
    private BigDecimal saldoSobregiroUtilizado;
    private boolean activa;

    public CuentaCorriente(String numeroCuenta, Cliente cliente, BigDecimal saldoInicial,
                           BigDecimal limiteSobregiro, BigDecimal comisionMensual) {
        super(numeroCuenta, cliente, saldoInicial);
        this.limiteSobregiro = limiteSobregiro;
        this.comisionMensual = comisionMensual;
        this.saldoSobregiroUtilizado = BigDecimal.ZERO;
        this.activa = true;
    }

    @Override
    public void depositar(BigDecimal monto) {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser mayor que cero");
        }

        // Primero compensamos el sobregiro utilizado si existe
        if (saldoSobregiroUtilizado.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal montoParaSobregiro = monto.min(saldoSobregiroUtilizado);
            saldoSobregiroUtilizado = saldoSobregiroUtilizado.subtract(montoParaSobregiro);
            monto = monto.subtract(montoParaSobregiro);
        }

        // El resto se deposita al saldo
        if (monto.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal nuevoSaldo = getSaldo().add(monto);
            actualizarSaldo(nuevoSaldo);
        }
    }

    @Override
    public void retirar(BigDecimal monto) throws SaldoInsuficienteException {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor que cero");
        }

        BigDecimal saldoDisponible = getSaldo().add(limiteSobregiro).subtract(saldoSobregiroUtilizado);

        if (monto.compareTo(saldoDisponible) > 0) {
            throw new SaldoInsuficienteException(
                "Saldo insuficiente. Disponible: " + saldoDisponible + ", Solicitado: " + monto
            );
        }

        BigDecimal nuevoSaldo = getSaldo().subtract(monto);

        if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0) {
            // Usamos sobregiro
            saldoSobregiroUtilizado = saldoSobregiroUtilizado.add(nuevoSaldo.abs());
            actualizarSaldo(BigDecimal.ZERO);
        } else {
            actualizarSaldo(nuevoSaldo);
        }
    }

    /**
     * Aplica la comisión mensual a la cuenta corriente.
     * Este método demuestra polimorfismo: cada tipo de cuenta implementa su propia lógica.
     */
    public void aplicarComisionMensual() {
        if (!activa) {
            return;
        }
        try {
            retirar(comisionMensual);
        } catch (SaldoInsuficienteException e) {
            // Si no hay saldo suficiente, se acumula como deuda
            BigDecimal nuevoSaldo = getSaldo().subtract(comisionMensual);
            actualizarSaldo(nuevoSaldo);
        }
    }

    /**
     * Calcula el interés aplicable al sobregiro utilizado.
     * Las cuentas corrientes cobran intereses por el uso del sobregiro.
     */
    public BigDecimal calcularInteresSobregiro(BigDecimal tasaAnual) {
        if (saldoSobregiroUtilizado.compareTo(BigDecimal.ZERO) <= 0) {
            return BigDecimal.ZERO;
        }
        // Interés proporcional al tiempo (mensual)
        BigDecimal tasaMensual = tasaAnual.divide(BigDecimal.valueOf(12), 6, java.math.RoundingMode.HALF_UP);
        return saldoSobregiroUtilizado.multiply(tasaMensual);
    }

    /**
     * Consulta el saldo disponible considerando el límite de sobregiro.
     */
    public BigDecimal getSaldoDisponible() {
        return getSaldo().add(limiteSobregiro).subtract(saldoSobregiroUtilizado);
    }

    /**
     * Consulta cuánto del límite de sobregiro está disponible.
     */
    public BigDecimal getSobregiroDisponible() {
        return limiteSobregiro.subtract(saldoSobregiroUtilizado);
    }

    public BigDecimal getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public BigDecimal getComisionMensual() {
        return comisionMensual;
    }

    public BigDecimal getSaldoSobregiroUtilizado() {
        return saldoSobregiroUtilizado;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    private void actualizarSaldo(BigDecimal nuevoSaldo) {
        try {
            var saldoField = CuentaBancaria.class.getDeclaredField("saldo");
            saldoField.setAccessible(true);
            saldoField.set(this, nuevoSaldo);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar saldo", e);
        }
    }
}

// === ARCHIVO: src/main/java/com/bank/domain/model/Transaccion.java ===
package com.bank.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Transaccion representa una operación bancaria en el sistema.
 * Encapsula toda la información relacionada con movimientos financieros,
 * aplicando el principio de encapsulamiento para proteger la integridad de los datos.
 */
public class Transaccion {

    private final UUID id;
    private final String numeroCuentaOrigen;
    private final String numeroCuentaDestino;
    private final BigDecimal monto;
    private final TipoTransaccion tipo;
    private final LocalDateTime fecha;
    private final String descripcion;
    private EstadoTransaccion estado;
    private String referencia;

    public enum TipoTransaccion {
        DEPOSITO,
        RETIRO,
        TRANSFERENCIA,
        PAGO_SERVICIO,
        COMISION,
        INTERES
    }

    public enum EstadoTransaccion {
        PENDIENTE,
        COMPLETADA,
        FALLIDA,
        CANCELADA
    }

    public Transaccion(String numeroCuentaOrigen, String numeroCuentaDestino,
                      BigDecimal monto, TipoTransaccion tipo, String descripcion) {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que cero");
        }
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de transacción es obligatorio");
        }

        this.id = UUID.randomUUID();
        this.numeroCuentaOrigen = numeroCuentaOrigen;
        this.numeroCuentaDestino = numeroCuentaDestino;
        this.monto = monto;
        this.tipo = tipo;
        this.fecha = LocalDateTime.now();
        this.descripcion = descripcion;
        this.estado = EstadoTransaccion.PENDIENTE;
        this.referencia = generarReferencia();
    }

    private String generarReferencia() {
        return String.format("TXN-%s-%s",
            fecha.toString().replace("-", "").replace(":", ""),
            id.toString().substring(0, 8).toUpperCase()
        );
    }

    /**
     * Completa la transacción cambiando su estado a COMPLETADA.
     * Este método aplica el principio de encapsulamiento al controlar
     * las transiciones de estado válidas.
     */
    public void completar() {
        if (this.estado != EstadoTransaccion.PENDIENTE) {
            throw new IllegalStateException(
                "Solo se pueden completar transacciones en estado PENDIENTE"
            );
        }
        this.estado = EstadoTransaccion.COMPLETADA;
    }

    /**
     * Marca la transacción como fallida con un motivo.
     */
    public void fallar(String motivo) {
        if (this.estado != EstadoTransaccion.PENDIENTE) {
            throw new IllegalStateException(
                "Solo se pueden fallar transacciones en estado PENDIENTE"
            );
        }
        this.estado = EstadoTransaccion.FALLIDA;
        this.descripcion = descripcion + " | Fallo: " + motivo;
    }

    /**
     * Cancela la transacción si aún está pendiente.
     */
    public void cancelar() {
        if (this.estado != EstadoTransaccion.PENDIENTE) {
            throw new IllegalStateException(
                "Solo se pueden cancelar transacciones en estado PENDIENTE"
            );
        }
        this.estado = EstadoTransaccion.CANCELADA;
    }

    /**
     * Verifica si la transacción es de ingreso (a favor del cliente).
     */
    public boolean isIngreso() {
        return tipo == TipoTransaccion.DEPOSITO ||
               tipo == TipoTransaccion.TRANSFERENCIA && numeroCuentaDestino != null;
    }

    /**
     * Verifica si la transacción es de egreso (en contra del cliente).
     */
    public boolean isEgreso() {
        return tipo == TipoTransaccion.RETIRO ||
               tipo == TipoTransaccion.PAGO_SERVICIO ||
               tipo == TipoTransaccion.COMISION;
    }

    /**
     * Verifica si la transacción es una transferencia entre cuentas.
     */
    public boolean isTransferencia() {
        return tipo == TipoTransaccion.TRANSFERENCIA;
    }

    public UUID getId() {
        return id;
    }

    public String getNumeroCuentaOrigen() {
        return numeroCuentaOrigen;
    }

    public String getNumeroCuentaDestino() {
        return numeroCuentaDestino;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public TipoTransaccion getTipo() {
        return tipo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EstadoTransaccion getEstado() {
        return estado;
    }

    public String getReferencia() {
        return referencia;
    }

    @Override
    public String toString() {
        return String.format("Transaccion{referencia=%s, tipo=%s, monto=%s, estado=%s, fecha=%s}",
            referencia, tipo, monto, estado, fecha);
    }
}

// === ARCHIVO: src/main/java/com/bank/domain/ports/CuentaRepository.java ===
package com.bank.domain.ports;

import com.bank.domain.model.CuentaBancaria;
import com.bank.domain.model.Cliente;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Puerto que define el contrato de persistencia para cuentas bancarias.
 * Esta interfaz vive en la capa de dominio ("puente") y es implementada
 * por la capa de infraestructura ("adaptador"), aplicando el patrón Ports & Adapters.
 * 
 * El dominio define QUÉ se necesita hacer (abstracción) sin conocer
 * CÓMO se hace (implementación concreta).
 */
public interface CuentaRepository {

    /**
     * Busca una cuenta por su identificador único.
     * @param id el UUID de la cuenta
     * @return Optional con la cuenta si existe, vacío si no
     */
    Optional<CuentaBancaria> findById(UUID id);

    /**
     * Busca una cuenta por su número de cuenta.
     * @param numeroCuenta el número identificador de la cuenta
     * @return Optional con la cuenta si existe, vacío si no
     */
    Optional<CuentaBancaria> findByNumeroCuenta(String numeroCuenta);

    /**
     * Busca todas las cuentas asociadas a un cliente.
     * @param cliente el cliente propietario de las cuentas
     * @return lista de cuentas del cliente
     */
    List<CuentaBancaria> findByCliente(Cliente cliente);

    /**
     * Busca todas las cuentas de un tipo específico.
     * @param tipoCuenta la clase que representa el tipo de cuenta
     * @return lista de cuentas del tipo especificado
     */
    <T extends CuentaBancaria> List<T> findByType(Class<T> tipoCuenta);

    /**
     * Persiste una cuenta en el repositorio.
     * @param cuenta la cuenta a guardar
     * @return la cuenta persistida con su ID asignado
     */
    CuentaBancaria save(CuentaBancaria cuenta);

    /**
     * Actualiza el saldo de una cuenta existente.
     * @param numeroCuenta el número de cuenta a actualizar
     * @param nuevoSaldo el nuevo saldo
     * @return true si se actualizó correctamente
     */
    boolean updateSaldo(String numeroCuenta, BigDecimal nuevoSaldo);

    /**
     * Elimina una cuenta del repositorio.
     * @param cuenta la cuenta a eliminar
     */
    void delete(CuentaBancaria cuenta);

    /**
     * Verifica si existe una cuenta con el número dado.
     * @param numeroCuenta el número de cuenta a verificar
     * @return true si existe la cuenta
     */
    boolean existsByNumeroCuenta(String numeroCuenta);

    /**
     * Cuenta el número total de cuentas en el repositorio.
     * @return cantidad de cuentas
     */
    long count();

    /**
     * Busca cuentas cuyo saldo sea mayor o igual al monto especificado.
     * @param monto el monto mínimo de saldo
     * @return lista de cuentas que cumplen el criterio
     */
    List<CuentaBancaria> findBySaldoGreaterThanEqual(BigDecimal monto);

    /**
     * Busca cuentas cuyo saldo sea menor al monto especificado.
     * Útil para identificar cuentas con saldo bajo.
     * @param monto el monto máximo de saldo
     * @return lista de cuentas que cumplen el criterio
     */
    List<CuentaBancaria> findBySaldoLessThan(BigDecimal monto);
}

// === ARCHIVO: src/main/java/com/bank/domain/ports/TransaccionRepository.java ===
package com.bank.domain.ports;

import com.bank.domain.model.Transaccion;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransaccionRepository {
    Transaccion save(Transaccion transaccion);
    Optional<Transaccion> findById(UUID id);
    List<Transaccion> findAll();
    List<Transaccion> findByCuentaOrigenId(UUID cuentaOrigenId);
    List<Transaccion> findByCuentaDestinoId(UUID cuentaDestinoId);
    List<Transaccion> findByCuentaId(UUID cuentaId);
    void deleteById(UUID id);
    boolean existsById(UUID id);
}

// === ARCHIVO: src/main/java/com/bank/application/CuentaService.java ===
package com.bank.application;

import com.bank.domain.model.Cliente;
import com.bank.domain.model.CuentaAhorro;
import com.bank.domain.model.CuentaBancaria;
import com.bank.domain.model.CuentaBancaria.SaldoInsuficienteException;
import com.bank.domain.ports.CuentaRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CuentaService {
    private final CuentaRepository cuentaRepository;

    public CuentaService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public CuentaBancaria crearCuentaAhorro(Cliente cliente, BigDecimal saldoInicial, BigDecimal tasaInteres) {
        validarCliente(cliente);
        validarMontoPositivo(saldoInicial, "Saldo inicial");
        validarTasaInteres(tasaInteres);
        
        String numeroCuenta = generarNumeroCuenta();
        CuentaAhorro cuenta = new CuentaAhorro(numeroCuenta, cliente, saldoInicial, tasaInteres);
        return cuentaRepository.save(cuenta);
    }

    public Optional<CuentaBancaria> buscarPorId(UUID id) {
        return cuentaRepository.findById(id);
    }

    public List<CuentaBancaria> listarTodas() {
        return cuentaRepository.findAll();
    }

    public List<CuentaBancaria> buscarPorCliente(UUID clienteId) {
        return cuentaRepository.findByClienteId(clienteId);
    }

    public void depositar(UUID cuentaId, BigDecimal monto) {
        validarMontoPositivo(monto, "Monto a depositar");
        
        CuentaBancaria cuenta = cuentaRepository.findById(cuentaId)
            .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada: " + cuentaId));
        
        cuenta.depositar(monto);
        cuentaRepository.save(cuenta);
    }

    public void retirar(UUID cuentaId, BigDecimal monto) throws SaldoInsuficienteException {
        validarMontoPositivo(monto, "Monto a retirar");
        
        CuentaBancaria cuenta = cuentaRepository.findById(cuentaId)
            .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada: " + cuentaId));
        
        cuenta.retirar(monto);
        cuentaRepository.save(cuenta);
    }

    public void transferir(UUID cuentaOrigenId, UUID cuentaDestinoId, BigDecimal monto) 
            throws SaldoInsuficienteException {
        validarMontoPositivo(monto, "Monto a transferir");
        
        CuentaBancaria cuentaOrigen = cuentaRepository.findById(cuentaOrigenId)
            .orElseThrow(() -> new IllegalArgumentException("Cuenta origen no encontrada: " + cuentaOrigenId));
        
        CuentaBancaria cuentaDestino = cuentaRepository.findById(cuentaDestinoId)
            .orElseThrow(() -> new IllegalArgumentException("Cuenta destino no encontrada: " + cuentaDestinoId));
        
        cuentaOrigen.transferir(cuentaDestino, monto);
        cuentaRepository.save(cuentaOrigen);
        cuentaRepository.save(cuentaDestino);
    }

    public BigDecimal consultarSaldo(UUID cuentaId) {
        CuentaBancaria cuenta = cuentaRepository.findById(cuentaId)
            .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada: " + cuentaId));
        return cuenta.getSaldo();
    }

    public void eliminarCuenta(UUID cuentaId) {
        if (!cuentaRepository.existsById(cuentaId)) {
            throw new IllegalArgumentException("Cuenta no encontrada: " + cuentaId);
        }
        cuentaRepository.deleteById(cuentaId);
    }

    private void validarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }
        if (!cliente.esMayorDeEdad()) {
            throw new IllegalArgumentException("El cliente debe ser mayor de edad para crear una cuenta");
        }
    }

    private void validarMontoPositivo(BigDecimal monto, String concepto) {
        if (monto == null) {
            throw new IllegalArgumentException(concepto + " no puede ser nulo");
        }
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(concepto + " debe ser mayor a cero");
        }
    }

    private void validarTasaInteres(BigDecimal tasaInteres) {
        if (tasaInteres == null) {
            throw new IllegalArgumentException("La tasa de interés no puede ser nula");
        }
        if (tasaInteres.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("La tasa de interés no puede ser negativa");
        }
        if (tasaInteres.compareTo(new BigDecimal("1.00")) > 0) {
            throw new IllegalArgumentException("La tasa de interés no puede exceder el 100%");
        }
    }

    private String generarNumeroCuenta() {
        return "CA-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}

// === ARCHIVO: src/main/java/com/bank/application/TransaccionService.java ===
package com.bank.application;

import com.bank.domain.model.CuentaBancaria;
import com.bank.domain.model.CuentaBancaria.SaldoInsuficienteException;
import com.bank.domain.model.Transaccion;
import com.bank.domain.ports.CuentaRepository;
import com.bank.domain.ports.TransaccionRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TransaccionService {
    private final TransaccionRepository transaccionRepository;
    private final CuentaRepository cuentaRepository;

    public TransaccionService(TransaccionRepository transaccionRepository, CuentaRepository cuentaRepository) {
        this.transaccionRepository = transaccionRepository;
        this.cuentaRepository = cuentaRepository;
    }

    public Transaccion realizarDeposito(UUID cuentaId, BigDecimal monto) {
        validarMontoPositivo(monto);
        validarCuentaExistente(cuentaId);
        
        CuentaBancaria cuenta = cuentaRepository.findById(cuentaId)
            .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada: " + cuentaId));
        
        cuenta.depositar(monto);
        cuentaRepository.save(cuenta);
        
        Transaccion transaccion = new Transaccion(
            UUID.randomUUID(),
            cuentaId,
            null,
            monto,
            Transaccion.Tipo.DEPOSITO,
            LocalDateTime.now(),
            "Depósito realizado exitosamente"
        );
        
        return transaccionRepository.save(transaccion);
    }

    public Transaccion realizarRetiro(UUID cuentaId, BigDecimal monto) throws SaldoInsuficienteException {
        validarMontoPositivo(monto);
        validarCuentaExistente(cuentaId);
        
        CuentaBancaria cuenta = cuentaRepository.findById(cuentaId)
            .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada: " + cuentaId));
        
        cuenta.retirar(monto);
        cuentaRepository.save(cuenta);
        
        Transaccion transaccion = new Transaccion(
            UUID.randomUUID(),
            cuentaId,
            null,
            monto.negate(),
            Transaccion.Tipo.RETIRO,
            LocalDateTime.now(),
            "Retiro realizado exitosamente"
        );
        
        return transaccionRepository.save(transaccion);
    }

    public Transaccion realizarTransferencia(UUID cuentaOrigenId, UUID cuentaDestinoId, BigDecimal monto) 
            throws SaldoInsuficienteException {
        validarMontoPositivo(monto);
        validarCuentaExistente(cuentaOrigenId);
        validarCuentaExistente(cuentaDestinoId);
        
        if (cuentaOrigenId.equals(cuentaDestinoId)) {
            throw new IllegalArgumentException("No se puede transferir a la misma cuenta");
        }
        
        CuentaBancaria cuentaOrigen = cuentaRepository.findById(cuentaOrigenId).get();
        CuentaBancaria cuentaDestino = cuentaRepository.findById(cuentaDestinoId).get();
        
        cuentaOrigen.transferir(cuentaDestino, monto);
        cuentaRepository.save(cuentaOrigen);
        cuentaRepository.save(cuentaDestino);
        
        Transaccion transaccion = new Transaccion(
            UUID.randomUUID(),
            cuentaOrigenId,
            cuentaDestinoId,
            monto.negate(),
            Transaccion.Tipo.TRANSFERENCIA,
            LocalDateTime.now(),
            "Transferencia realizada exitosamente"
        );
        
        return transaccionRepository.save(transaccion);
    }

    public Optional<Transaccion> buscarPorId(UUID id) {
        return transaccionRepository.findById(id);
    }

    public List<Transaccion> listarTodas() {
        return transaccionRepository.findAll();
    }

    public List<Transaccion> buscarPorCuenta(UUID cuentaId) {
        validarCuentaExistente(cuentaId);
        return transaccionRepository.findByCuentaId(cuentaId);
    }

    public List<Transaccion> buscarHistorialOrigen(UUID cuentaId) {
        validarCuentaExistente(cuentaId);
        return transaccionRepository.findByCuentaOrigenId(cuentaId);
    }

    public List<Transaccion> buscarHistorialDestino(UUID cuentaId) {
        validarCuentaExistente(cuentaId);
        return transaccionRepository.findByCuentaDestinoId(cuentaId);
    }

    public void eliminarTransaccion(UUID id) {
        if (!transaccionRepository.existsById(id)) {
            throw new IllegalArgumentException("Transacción no encontrada: " + id);
        }
        transaccionRepository.deleteById(id);
    }

    public BigDecimal calcularTotalMovimientos(UUID cuentaId, Transaccion.Tipo tipo) {
        List<Transaccion> transacciones = transaccionRepository.findByCuentaId(cuentaId);
        return transacciones.stream()
            .filter(t -> t.getTipo() == tipo)
            .map(Transaccion::getMonto)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calcularDepositosTotales(UUID cuentaId) {
        return calcularTotalMovimientos(cuentaId, Transaccion.Tipo.DEPOSITO);
    }

    public BigDecimal calcularRetirosTotales(UUID cuentaId) {
        return calcularTotalMovimientos(cuentaId, Transaccion.Tipo.RETIRO).abs();
    }

    private void validarMontoPositivo(BigDecimal monto) {
        if (monto == null) {
            throw new IllegalArgumentException("El monto no puede ser nulo");
        }
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero");
        }
    }

    private void validarCuentaExistente(UUID cuentaId) {
        if (!cuentaRepository.existsById(cuentaId)) {
            throw new IllegalArgumentException("La cuenta no existe: " + cuentaId);
        }
    }
}

// === ARCHIVO: src/main/java/com/bank/infrastructure/adapters/CuentaJpaAdapter.java ===
package com.bank.infrastructure.adapters;


import com.bank.domain.model.TipoIdentificacion;
import com.bank.domain.model.CuentaAhorro;
import com.bank.domain.model.CuentaBancaria;
import com.bank.domain.model.Cliente;
import com.bank.domain.ports.CuentaRepository;
import org.springframework.stereotype.Repository;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class CuentaJpaAdapter implements CuentaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<CuentaBancaria> findById(UUID id) {
        CuentaBancariaEntity entity = entityManager.find(CuentaBancariaEntity.class, id);
        if (entity == null) {
            return Optional.empty();
        }
        return Optional.of(mapToDomain(entity));
    }

    @Override
    public Optional<CuentaBancaria> findByNumeroCuenta(String numeroCuenta) {
        TypedQuery<CuentaBancariaEntity> query = entityManager.createQuery(
            "SELECT c FROM CuentaBancariaEntity c WHERE c.numeroCuenta = :numero",
            CuentaBancariaEntity.class
        );
        query.setParameter("numero", numeroCuenta);
        List<CuentaBancariaEntity> results = query.getResultList();
        if (results.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(mapToDomain(results.get(0)));
    }

    @Override
    public List<CuentaBancaria> findByClienteId(UUID clienteId) {
        TypedQuery<CuentaBancariaEntity> query = entityManager.createQuery(
            "SELECT c FROM CuentaBancariaEntity c WHERE c.clienteId = :clienteId",
            CuentaBancariaEntity.class
        );
        query.setParameter("clienteId", clienteId);
        return query.getResultList().stream()
            .map(this::mapToDomain)
            .toList();
    }

    @Override
    public List<CuentaBancaria> findAll() {
        return entityManager.createQuery(
            "SELECT c FROM CuentaBancariaEntity c",
            CuentaBancariaEntity.class
        ).getResultList().stream()
            .map(this::mapToDomain)
            .toList();
    }

    @Override
    public CuentaBancaria save(CuentaBancaria cuenta) {
        CuentaBancariaEntity entity = mapToEntity(cuenta);
        if (cuenta.getId() == null) {
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }
        entityManager.flush();
        return mapToDomain(entity);
    }

    @Override
    public void deleteById(UUID id) {
        CuentaBancariaEntity entity = entityManager.find(CuentaBancariaEntity.class, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    @Override
    public boolean existsByNumeroCuenta(String numeroCuenta) {
        TypedQuery<Long> query = entityManager.createQuery(
            "SELECT COUNT(c) FROM CuentaBancariaEntity c WHERE c.numeroCuenta = :numero",
            Long.class
        );
        query.setParameter("numero", numeroCuenta);
        return query.getSingleResult() > 0;
    }

    private CuentaBancaria mapToDomain(CuentaBancariaEntity entity) {
        Cliente cliente = new Cliente(
            entity.getClienteNombre(),
            entity.getClienteApellido(),
            entity.getClienteEmail(),
            entity.getClienteFechaNacimiento(),
            entity.getClienteNumeroIdentificacion(),
            Cliente.TipoIdentificacion.valueOf(entity.getClienteTipoIdentificacion())
        );
        
        if ("AHORRO".equals(entity.getTipoCuenta())) {
            CuentaAhorro cuenta = new CuentaAhorro(
                entity.getNumeroCuenta(),
                cliente,
                entity.getSaldo(),
                entity.getTasaInteres()
            );
            return cuenta;
        } else {
            throw new IllegalStateException("Tipo de cuenta no soportado: " + entity.getTipoCuenta());
        }
    }

    private CuentaBancariaEntity mapToEntity(CuentaBancaria cuenta) {
        CuentaBancariaEntity entity = new CuentaBancariaEntity();
        entity.setId(cuenta.getId());
        entity.setNumeroCuenta(cuenta.getNumeroCuenta());
        entity.setSaldo(cuenta.getSaldo());
        entity.setFechaCreacion(cuenta.getFechaCreacion());
        
        if (cuenta instanceof CuentaAhorro cuentaAhorro) {
            entity.setTipoCuenta("AHORRO");
            entity.setTasaInteres(cuentaAhorro.getTasaInteres());
        }
        
        Cliente cliente = cuenta.getCliente();
        entity.setClienteId(cliente.getId());
        entity.setClienteNombre(cliente.getNombre());
        entity.setClienteApellido(cliente.getApellido());
        entity.setClienteEmail(cliente.getEmail());
        entity.setClienteFechaNacimiento(cliente.getFechaNacimiento());
        entity.setClienteNumeroIdentificacion(cliente.getNumeroIdentificacion());
        entity.setClienteTipoIdentificacion(cliente.getTipoIdentificacion().name());
        
        return entity;
    }

    @Entity
    @Table(name = "cuentas_bancarias")
    public static class CuentaBancariaEntity {
        @Id
        private UUID id;
        
        @Column(name = "numero_cuenta", unique = true, nullable = false)
        private String numeroCuenta;
        
        @Column(name = "saldo", nullable = false)
        private BigDecimal saldo;
        
        @Column(name = "fecha_creacion", nullable = false)
        private LocalDateTime fechaCreacion;
        
        @Column(name = "tipo_cuenta", nullable = false)
        private String tipoCuenta;
        
        @Column(name = "tasa_interes")
        private BigDecimal tasaInteres;
        
        @Column(name = "cliente_id", nullable = false)
        private UUID clienteId;
        
        @Column(name = "cliente_nombre", nullable = false)
        private String clienteNombre;
        
        @Column(name = "cliente_apellido", nullable = false)
        private String clienteApellido;
        
        @Column(name = "cliente_email")
        private String clienteEmail;
        
        @Column(name = "cliente_fecha_nacimiento")
        private java.time.LocalDate clienteFechaNacimiento;
        
        @Column(name = "cliente_numero_identificacion")
        private String clienteNumeroIdentificacion;
        
        @Column(name = "cliente_tipo_identificacion")
        private String clienteTipoIdentificacion;

        public UUID getId() { return id; }
        public void setId(UUID id) { this.id = id; }
        public String getNumeroCuenta() { return numeroCuenta; }
        public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }
        public BigDecimal getSaldo() { return saldo; }
        public void setSaldo(BigDecimal saldo) { this.saldo = saldo; }
        public LocalDateTime getFechaCreacion() { return fechaCreacion; }
        public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
        public String getTipoCuenta() { return tipoCuenta; }
        public void setTipoCuenta(String tipoCuenta) { this.tipoCuenta = tipoCuenta; }
        public BigDecimal getTasaInteres() { return tasaInteres; }
        public void setTasaInteres(BigDecimal tasaInteres) { this.tasaInteres = tasaInteres; }
        public UUID getClienteId() { return clienteId; }
        public void setClienteId(UUID clienteId) { this.clienteId = clienteId; }
        public String getClienteNombre() { return clienteNombre; }
        public void setClienteNombre(String clienteNombre) { this.clienteNombre = clienteNombre; }
        public String getClienteApellido() { return clienteApellido; }
        public void setClienteApellido(String clienteApellido) { this.clienteApellido = clienteApellido; }
        public String getClienteEmail() { return clienteEmail; }
        public void setClienteEmail(String clienteEmail) { this.clienteEmail = clienteEmail; }
        public java.time.LocalDate getClienteFechaNacimiento() { return clienteFechaNacimiento; }
        public void setClienteFechaNacimiento(java.time.LocalDate clienteFechaNacimiento) { this.clienteFechaNacimiento = clienteFechaNacimiento; }
        public String getClienteNumeroIdentificacion() { return clienteNumeroIdentificacion; }
        public void setClienteNumeroIdentificacion(String clienteNumeroIdentificacion) { this.clienteNumeroIdentificacion = clienteNumeroIdentificacion; }
        public String getClienteTipoIdentificacion() { return clienteTipoIdentificacion; }
        public void setClienteTipoIdentificacion(String clienteTipoIdentificacion) { this.clienteTipoIdentificacion = clienteTipoIdentificacion; }
    }
}

// === ARCHIVO: src/main/java/com/bank/infrastructure/adapters/TransaccionJpaAdapter.java ===
package com.bank.infrastructure.adapters;

import com.bank.domain.model.Transaccion;
import com.bank.domain.model.Transaccion.TipoTransaccion;
import com.bank.domain.ports.TransaccionRepository;
import org.springframework.stereotype.Repository;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class TransaccionJpaAdapter implements TransaccionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Transaccion> findById(UUID id) {
        TransaccionEntity entity = entityManager.find(TransaccionEntity.class, id);
        if (entity == null) {
            return Optional.empty();
        }
        return Optional.of(mapToDomain(entity));
    }

    @Override
    public List<Transaccion> findByCuentaId(UUID cuentaId) {
        TypedQuery<TransaccionEntity> query = entityManager.createQuery(
            "SELECT t FROM TransaccionEntity t WHERE t.cuentaId = :cuentaId ORDER BY t.fecha DESC",
            TransaccionEntity.class
        );
        query.setParameter("cuentaId", cuentaId);
        return query.getResultList().stream()
            .map(this::mapToDomain)
            .toList();
    }

    @Override
    public List<Transaccion> findByCuentaIdAndFechaBetween(UUID cuentaId, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        TypedQuery<TransaccionEntity> query = entityManager.createQuery(
            "SELECT t FROM TransaccionEntity t WHERE t.cuentaId = :cuentaId AND t.fecha BETWEEN :fechaInicio AND :fechaFin ORDER BY t.fecha DESC",
            TransaccionEntity.class
        );
        query.setParameter("cuentaId", cuentaId);
        query.setParameter("fechaInicio", fechaInicio);
        query.setParameter("fechaFin", fechaFin);
        return query.getResultList().stream()
            .map(this::mapToDomain)
            .toList();
    }

    @Override
    public List<Transaccion> findAll() {
        return entityManager.createQuery(
            "SELECT t FROM TransaccionEntity t ORDER BY t.fecha DESC",
            TransaccionEntity.class
        ).getResultList().stream()
            .map(this::mapToDomain)
            .toList();
    }

    @Override
    public Transaccion save(Transaccion transaccion) {
        TransaccionEntity entity = mapToEntity(transaccion);
        if (transaccion.getId() == null) {
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }
        entityManager.flush();
        return mapToDomain(entity);
    }

    @Override
    public void deleteById(UUID id) {
        TransaccionEntity entity = entityManager.find(TransaccionEntity.class, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    @Override
    public List<Transaccion> findByTipo(TipoTransaccion tipo) {
        TypedQuery<TransaccionEntity> query = entityManager.createQuery(
            "SELECT t FROM TransaccionEntity t WHERE t.tipo = :tipo ORDER BY t.fecha DESC",
            TransaccionEntity.class
        );
        query.setParameter("tipo", tipo.name());
        return query.getResultList().stream()
            .map(this::mapToDomain)
            .toList();
    }

    private Transaccion mapToDomain(TransaccionEntity entity) {
        return new Transaccion(
            entity.getId(),
            entity.getCuentaId(),
            TipoTransaccion.valueOf(entity.getTipo()),
            entity.getMonto(),
            entity.getFecha(),
            entity.getDescripcion()
        );
    }

    private TransaccionEntity mapToEntity(Transaccion transaccion) {
        TransaccionEntity entity = new TransaccionEntity();
        entity.setId(transaccion.getId());
        entity.setCuentaId(transaccion.getCuentaId());
        entity.setTipo(transaccion.getTipo().name());
        entity.setMonto(transaccion.getMonto());
        entity.setFecha(transaccion.getFecha());
        entity.setDescripcion(transaccion.getDescripcion());
        return entity;
    }

    @Entity
    @Table(name = "transacciones")
    public static class TransaccionEntity {
        @Id
        private UUID id;
        
        @Column(name = "cuenta_id", nullable = false)
        private UUID cuentaId;
        
        @Column(name = "tipo", nullable = false)
        private String tipo;
        
        @Column(name = "monto", nullable = false)
        private BigDecimal monto;
        
        @Column(name = "fecha", nullable = false)
        private LocalDateTime fecha;
        
        @Column(name = "descripcion")
        private String descripcion;

        public UUID getId() { return id; }
        public void setId(UUID id) { this.id = id; }
        public UUID getCuentaId() { return cuentaId; }
        public void setCuentaId(UUID cuentaId) { this.cuentaId = cuentaId; }
        public String getTipo() { return tipo; }
        public void setTipo(String tipo) { this.tipo = tipo; }
        public BigDecimal getMonto() { return monto; }
        public void setMonto(BigDecimal monto) { this.monto = monto; }
        public LocalDateTime getFecha() { return fecha; }
        public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
        public String getDescripcion() { return descripcion; }
        public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    }
}

// === ARCHIVO: src/main/java/com/bank/infrastructure/controllers/CuentaController.java ===
package com.bank.infrastructure.controllers;


import com.bank.domain.model.SaldoInsuficienteException;
import com.bank.application.CuentaService;
import com.bank.domain.model.CuentaBancaria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuentaResponse> obtenerCuenta(@PathVariable UUID id) {
        return cuentaService.buscarPorId(id)
            .map(cuenta -> ResponseEntity.ok(mapToResponse(cuenta)))
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/numero/{numeroCuenta}")
    public ResponseEntity<CuentaResponse> obtenerPorNumero(@PathVariable String numeroCuenta) {
        return cuentaService.buscarPorNumero(numeroCuenta)
            .map(cuenta -> ResponseEntity.ok(mapToResponse(cuenta)))
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CuentaResponse>> listarCuentas() {
        List<CuentaResponse> cuentas = cuentaService.listarTodas()
            .stream()
            .map(this::mapToResponse)
            .toList();
        return ResponseEntity.ok(cuentas);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<CuentaResponse>> listarCuentasPorCliente(@PathVariable UUID clienteId) {
        List<CuentaResponse> cuentas = cuentaService.buscarPorCliente(clienteId)
            .stream()
            .map(this::mapToResponse)
            .toList();
        return ResponseEntity.ok(cuentas);
    }

    @PostMapping("/deposito")
    public ResponseEntity<CuentaResponse> realizarDeposito(@RequestBody DepositoRequest request) {
        try {
            CuentaBancaria cuenta = cuentaService.realizarDeposito(
                request.numeroCuenta(),
                request.monto()
            );
            return ResponseEntity.ok(mapToResponse(cuenta));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/retiro")
    public ResponseEntity<CuentaResponse> realizarRetiro(@RequestBody RetiroRequest request) {
        try {
            CuentaBancaria cuenta = cuentaService.realizarRetiro(
                request.numeroCuenta(),
                request.monto()
            );
            return ResponseEntity.ok(mapToResponse(cuenta));
        } catch (CuentaBancaria.SaldoInsuficienteException e) {
            return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/transferencia")
    public ResponseEntity<TransferenciaResponse> realizarTransferencia(@RequestBody TransferenciaRequest request) {
        try {
            cuentaService.realizarTransferencia(
                request.numeroCuentaOrigen(),
                request.numeroCuentaDestino(),
                request.monto()
            );
            return ResponseEntity.ok(new TransferenciaResponse(
                "Transferencia realizada exitosamente",
                true
            ));
        } catch (CuentaBancaria.SaldoInsuficienteException e) {
            return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED)
                .body(new TransferenciaResponse("Saldo insuficiente", false));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                .body(new TransferenciaResponse("Datos inválidos", false));
        }
    }

    private CuentaResponse mapToResponse(CuentaBancaria cuenta) {
        return new CuentaResponse(
            cuenta.getId().toString(),
            cuenta.getNumeroCuenta(),
            cuenta.getSaldo(),
            cuenta.getFechaCreacion().toString(),
            cuenta.getCliente().getNombreCompleto()
        );
    }

    public record CuentaResponse(
        String id,
        String numeroCuenta,
        BigDecimal saldo,
        String fechaCreacion,
        String nombreCliente
    ) {}

    public record DepositoRequest(
        String numeroCuenta,
        BigDecimal monto
    ) {}

    public record RetiroRequest(
        String numeroCuenta,
        BigDecimal monto
    ) {}

    public record TransferenciaRequest(
        String numeroCuentaOrigen,
        String numeroCuentaDestino,
        BigDecimal monto
    ) {}

    public record TransferenciaResponse(
        String mensaje,
        boolean exitosa
    ) {}
}

// === ARCHIVO: src/main/java/com/bank/infrastructure/controllers/TransaccionController.java ===
package com.bank.infrastructure.controllers;


import com.bank.domain.model.SaldoInsuficienteException;
import com.bank.application.TransaccionService;
import com.bank.domain.model.CuentaBancaria;
import com.bank.domain.model.Transaccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transacciones")
public class TransaccionController {

    private final TransaccionService transaccionService;

    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @PostMapping
    public ResponseEntity<TransaccionResponse> registrarTransaccion(
            @Valid @RequestBody TransaccionRequest request) {
        Transaccion transaccion = transaccionService.registrarTransaccion(
                request.cuentaOrigenId(),
                request.cuentaDestinoId(),
                request.monto(),
                request.tipo()
        );
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(TransaccionResponse.from(transaccion));
    }

    @GetMapping("/cuenta/{cuentaId}")
    public ResponseEntity<List<TransaccionResponse>> obtenerTransaccionesPorCuenta(
            @PathVariable @NotNull UUID cuentaId) {
        List<Transaccion> transacciones = transaccionService.obtenerTransaccionesPorCuenta(cuentaId);
        List<TransaccionResponse> response = transacciones.stream()
                .map(TransaccionResponse::from)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransaccionResponse> obtenerTransaccionPorId(@PathVariable UUID id) {
        return transaccionService.obtenerTransaccionPorId(id)
                .map(transaccion -> ResponseEntity.ok(TransaccionResponse.from(transaccion)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/deposito")
    public ResponseEntity<TransaccionResponse> realizarDeposito(
            @Valid @RequestBody DepositoRequest request) {
        Transaccion transaccion = transaccionService.realizarDeposito(
                request.cuentaId(),
                request.monto()
        );
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(TransaccionResponse.from(transaccion));
    }

    @PostMapping("/retiro")
    public ResponseEntity<TransaccionResponse> realizarRetiro(
            @Valid @RequestBody RetiroRequest request) {
        try {
            Transaccion transaccion = transaccionService.realizarRetiro(
                    request.cuentaId(),
                    request.monto()
            );
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(TransaccionResponse.from(transaccion));
        } catch (CuentaBancaria.SaldoInsuficienteException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public record TransaccionRequest(
            @NotNull UUID cuentaOrigenId,
            UUID cuentaDestinoId,
            @NotNull BigDecimal monto,
            @NotNull String tipo
    ) {}

    public record DepositoRequest(
            @NotNull UUID cuentaId,
            @NotNull BigDecimal monto
    ) {}

    public record RetiroRequest(
            @NotNull UUID cuentaId,
            @NotNull BigDecimal monto
    ) {}

    public record TransaccionResponse(
            UUID id,
            UUID cuentaOrigenId,
            UUID cuentaDestinoId,
            BigDecimal monto,
            String tipo,
            String estado,
            String fecha
    ) {
        public static TransaccionResponse from(Transaccion transaccion) {
            return new TransaccionResponse(
                    transaccion.getId(),
                    transaccion.getCuentaOrigen() != null ? transaccion.getCuentaOrigen().getId() : null,
                    transaccion.getCuentaDestino() != null ? transaccion.getCuentaDestino().getId() : null,
                    transaccion.getMonto(),
                    transaccion.getTipo().name(),
                    transaccion.getEstado().name(),
                    transaccion.getFecha().toString()
            );
        }
    }
}

// === ARCHIVO: src/test/java/com/bank/application/CuentaServiceTest.java ===
package com.bank.application;



import com.bank.domain.model.SaldoInsuficienteException;
import com.bank.domain.model.TipoIdentificacion;
import com.bank.domain.model.Cliente;
import com.bank.domain.model.CuentaAhorro;
import com.bank.domain.model.CuentaBancaria;
import com.bank.domain.ports.CuentaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CuentaServiceTest {

    @Mock
    private CuentaRepository cuentaRepository;

    private CuentaService cuentaService;

    @BeforeEach
    void setUp() {
        cuentaService = new CuentaService(cuentaRepository);
    }

    @Test
    void crearCuentaAhorro_deberiaCrearCuentaConDatosValidos() {
        // Given
        Cliente cliente = new Cliente(
                "Juan",
                "Perez",
                "juan@example.com",
                LocalDate.of(1990, 5, 15),
                "12345678",
                Cliente.TipoIdentificacion.CEDULA
        );
        BigDecimal saldoInicial = new BigDecimal("1000.00");
        BigDecimal tasaInteres = new BigDecimal("0.05");

        when(cuentaRepository.guardar(any(CuentaBancaria.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // When
        CuentaAhorro cuenta = cuentaService.crearCuentaAhorro(
                cliente, saldoInicial, tasaInteres
        );

        // Then
        assertNotNull(cuenta);
        assertEquals(saldoInicial, cuenta.getSaldo());
        verify(cuentaRepository, times(1)).guardar(any(CuentaBancaria.class));
    }

    @Test
    void obtenerCuentaPorId_deberiaRetornarCuentaCuandoExiste() {
        // Given
        UUID cuentaId = UUID.randomUUID();
        Cliente cliente = new Cliente(
                "Maria",
                "Garcia",
                "maria@example.com",
                LocalDate.of(1985, 3, 20),
                "87654321",
                Cliente.TipoIdentificacion.CEDULA
        );
        CuentaAhorro cuentaEsperada = new CuentaAhorro(
                "ACC-001",
                cliente,
                new BigDecimal("5000.00"),
                new BigDecimal("0.04")
        );

        when(cuentaRepository.buscarPorId(cuentaId))
                .thenReturn(Optional.of(cuentaEsperada));

        // When
        Optional<CuentaBancaria> resultado = cuentaService.obtenerCuentaPorId(cuentaId);

        // Then
        assertTrue(resultado.isPresent());
        assertEquals(cuentaEsperada.getId(), resultado.get().getId());
    }

    @Test
    void obtenerCuentaPorId_deberiaRetornarVacioCuandoNoExiste() {
        // Given
        UUID cuentaId = UUID.randomUUID();
        when(cuentaRepository.buscarPorId(cuentaId))
                .thenReturn(Optional.empty());

        // When
        Optional<CuentaBancaria> resultado = cuentaService.obtenerCuentaPorId(cuentaId);

        // Then
        assertTrue(resultado.isEmpty());
    }

    @Test
    void depositar_deberiaIncrementarSaldoDeCuenta() throws Exception {
        // Given
        UUID cuentaId = UUID.randomUUID();
        Cliente cliente = new Cliente(
                "Carlos",
                "Lopez",
                "carlos@example.com",
                LocalDate.of(1992, 8, 10),
                "11223344",
                Cliente.TipoIdentificacion.PASAPORTE
        );
        CuentaAhorro cuenta = new CuentaAhorro(
                "ACC-002",
                cliente,
                new BigDecimal("1000.00"),
                new BigDecimal("0.03")
        );
        BigDecimal montoDeposito = new BigDecimal("500.00");

        when(cuentaRepository.buscarPorId(cuentaId)).thenReturn(Optional.of(cuenta));
        when(cuentaRepository.guardar(any(CuentaBancaria.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // When
        CuentaBancaria resultado = cuentaService.depositar(cuentaId, montoDeposito);

        // Then
        assertEquals(new BigDecimal("1500.00"), resultado.getSaldo());
        verify(cuentaRepository, times(1)).guardar(any(CuentaBancaria.class));
    }

    @Test
    void retirar_deberiaLanzarExcepcionCuandoSaldoInsuficiente() {
        // Given
        UUID cuentaId = UUID.randomUUID();
        Cliente cliente = new Cliente(
                "Ana",
                "Martinez",
                "ana@example.com",
                LocalDate.of(1988, 12, 5),
                "55667788",
                Cliente.TipoIdentificacion.CEDULA
        );
        CuentaAhorro cuenta = new CuentaAhorro(
                "ACC-003",
                cliente,
                new BigDecimal("100.00"),
                new BigDecimal("0.02")
        );
        BigDecimal montoRetiro = new BigDecimal("500.00");

        when(cuentaRepository.buscarPorId(cuentaId)).thenReturn(Optional.of(cuenta));

        // When / Then
        assertThrows(CuentaBancaria.SaldoInsuficienteException.class, () -> {
            cuentaService.retirar(cuentaId, montoRetiro);
        });
    }
}

// === ARCHIVO: src/test/java/com/bank/application/TransaccionServiceTest.java ===
package com.bank.application;



import com.bank.domain.model.SaldoInsuficienteException;
import com.bank.domain.model.TipoIdentificacion;
import com.bank.domain.model.Cliente;
import com.bank.domain.model.CuentaAhorro;
import com.bank.domain.model.CuentaBancaria;
import com.bank.domain.model.Transaccion;
import com.bank.domain.ports.CuentaRepository;
import com.bank.domain.ports.TransaccionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransaccionServiceTest {

    @Mock
    private TransaccionRepository transaccionRepository;

    @Mock
    private CuentaRepository cuentaRepository;

    private TransaccionService transaccionService;

    @BeforeEach
    void setUp() {
        transaccionService = new TransaccionService(transaccionRepository, cuentaRepository);
    }

    @Test
    void registrarTransaccion_deberiaCrearTransaccionEntreCuentas() throws Exception {
        // Given
        UUID cuentaOrigenId = UUID.randomUUID();
        UUID cuentaDestinoId = UUID.randomUUID();
        BigDecimal monto = new BigDecimal("1000.00");
        String tipo = "TRANSFERENCIA";

        Cliente clienteOrigen = new Cliente(
                "Pedro",
                "Gomez",
                "pedro@example.com",
                LocalDate.of(1990, 1, 1),
                "11111111",
                Cliente.TipoIdentificacion.CEDULA
        );
        Cliente clienteDestino = new Cliente(
                "Laura",
                "Fernandez",
                "laura@example.com",
                LocalDate.of(1992, 2, 2),
                "22222222",
                Cliente.TipoIdentificacion.CEDULA
        );

        CuentaAhorro cuentaOrigen = new CuentaAhorro(
                "ACC-100",
                clienteOrigen,
                new BigDecimal("5000.00"),
                new BigDecimal("0.05")
        );
        CuentaAhorro cuentaDestino = new CuentaAhorro(
                "ACC-200",
                clienteDestino,
                new BigDecimal("2000.00"),
                new BigDecimal("0.05")
        );

        when(cuentaRepository.buscarPorId(cuentaOrigenId))
                .thenReturn(Optional.of(cuentaOrigen));
        when(cuentaRepository.buscarPorId(cuentaDestinoId))
                .thenReturn(Optional.of(cuentaDestino));
        when(transaccionRepository.guardar(any(Transaccion.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));
        when(cuentaRepository.guardar(any(CuentaBancaria.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // When
        Transaccion resultado = transaccionService.registrarTransaccion(
                cuentaOrigenId, cuentaDestinoId, monto, tipo
        );

        // Then
        assertNotNull(resultado);
        assertEquals(monto, resultado.getMonto());
        verify(transaccionRepository, times(1)).guardar(any(Transaccion.class));
    }

    @Test
    void obtenerTransaccionesPorCuenta_deberiaRetornarListaDeTransacciones() {
        // Given
        UUID cuentaId = UUID.randomUUID();
        Cliente cliente = new Cliente(
                "Roberto",
                "Sanchez",
                "roberto@example.com",
                LocalDate.of(1985, 5, 15),
                "33333333",
                Cliente.TipoIdentificacion.CEDULA
        );
        CuentaAhorro cuenta = new CuentaAhorro(
                "ACC-300",
                cliente,
                new BigDecimal("10000.00"),
                new BigDecimal("0.04")
        );

        Transaccion transaccion1 = new Transaccion(
                cuenta, null, new BigDecimal("500.00"), Transaccion.Tipo.DEPOSITO
        );
        Transaccion transaccion2 = new Transaccion(
                null, cuenta, new BigDecimal("300.00"), Transaccion.Tipo.RETIRO
        );

        when(cuentaRepository.buscarPorId(cuentaId)).thenReturn(Optional.of(cuenta));
        when(transaccionRepository.buscarPorCuenta(cuentaId))
                .thenReturn(List.of(transaccion1, transaccion2));

        // When
        List<Transaccion> resultados = transaccionService.obtenerTransaccionesPorCuenta(cuentaId);

        // Then
        assertEquals(2, resultados.size());
    }

    @Test
    void realizarDeposito_deberiaCrearTransaccionYActualizarSaldo() throws Exception {
        // Given
        UUID cuentaId = UUID.randomUUID();
        BigDecimal monto = new BigDecimal("2000.00");

        Cliente cliente = new Cliente(
                "Sofia",
                "Ramirez",
                "sofia@example.com",
                LocalDate.of(1993, 7, 20),
                "44444444",
                Cliente.TipoIdentificacion.PASAPORTE
        );
        CuentaAhorro cuenta = new CuentaAhorro(
                "ACC-400",
                cliente,
                new BigDecimal("1000.00"),
                new BigDecimal("0.03")
        );

        when(cuentaRepository.buscarPorId(cuentaId)).thenReturn(Optional.of(cuenta));
        when(transaccionRepository.guardar(any(Transaccion.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));
        when(cuentaRepository.guardar(any(CuentaBancaria.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // When
        Transaccion resultado = transaccionService.realizarDeposito(cuentaId, monto);

        // Then
        assertNotNull(resultado);
        assertEquals(Transaccion.Tipo.DEPOSITO, resultado.getTipo());
        assertEquals(monto, resultado.getMonto());
    }

    @Test
    void realizarRetiro_deberiaLanzarExcepcionCuandoSaldoInsuficiente() {
        // Given
        UUID cuentaId = UUID.randomUUID();
        BigDecimal monto = new BigDecimal("10000.00");

        Cliente cliente = new Cliente(
                "Miguel",
                "Torres",
                "miguel@example.com",
                LocalDate.of(1980, 10, 10),
                "55555555",
                Cliente.TipoIdentificacion.CEDULA
        );
        CuentaAhorro cuenta = new CuentaAhorro(
                "ACC-500",
                cliente,
                new BigDecimal("500.00"),
                new BigDecimal("0.02")
        );

        when(cuentaRepository.buscarPorId(cuentaId)).thenReturn(Optional.of(cuenta));

        // When / Then
        assertThrows(CuentaBancaria.SaldoInsuficienteException.class, () -> {
            transaccionService.realizarRetiro(cuentaId, monto);
        });
    }

    @Test
    void obtenerTransaccionPorId_deberiaRetornarTransaccionCuandoExiste() {
        // Given
        UUID transaccionId = UUID.randomUUID();
        Cliente cliente = new Cliente(
                "Elena",
                "Vargas",
                "elena@example.com",
                LocalDate.of(1987, 3, 25),
                "66666666",
                Cliente.TipoIdentificacion.CEDULA
        );
        CuentaAhorro cuenta = new CuentaAhorro(
                "ACC-600",
                cliente,
                new BigDecimal("8000.00"),
                new BigDecimal("0.04")
        );
        Transaccion transaccionEsperada = new Transaccion(
                cuenta, null, new BigDecimal("1500.00"), Transaccion.Tipo.DEPOSITO
        );

        when(transaccionRepository.buscarPorId(transaccionId))
                .thenReturn(Optional.of(transaccionEsperada));

        // When
        Optional<Transaccion> resultado = transaccionService.obtenerTransaccionPorId(transaccionId);

        // Then
        assertTrue(resultado.isPresent());
        assertEquals(transaccionEsperada.getId(), resultado.get().getId());
    }
}

// === ARCHIVO: README.md ===
# Bank System - Sistema de Gestión Bancaria

## Descripción del Proyecto

Sistema de gestión bancaria desarrollado con Java 21 y Spring Boot 3.5 que implementa los principios fundamentales de la Programación Orientada a Objetos (OOP). El dominio incluye gestión de clientes, cuentas bancarias (ahorro y corriente), y transacciones financieras.

## Características Principales

- Gestión de clientes con validación de datos personales
- Dos tipos de cuentas: Cuenta de Ahorro y Cuenta Corriente
- Operaciones de depósito, retiro y transferencia
- Cálculo de intereses para cuentas de ahorro
- Historial de transacciones por cuenta
- API REST con documentación OpenAPI
- Persistencia en base de datos H2 en memoria

## Requisitos Previos

- **Java Development Kit (JDK)**: Versión 21 o superior
- **Maven**: Versión 3.8 o superior
- **Git**: Para clonar el repositorio (opcional)

Verificar instalación:
```bash
java -version
mvn -version
```

## Estructura del Proyecto

```
bank-system/
├── src/
│   ├── main/
│   │   ├── java/com/bank/
│   │   │   ├── Application.java              # Punto de entrada de la aplicación
│   │   │   ├── domain/
│   │   │   │   ├── model/                    # Entidades del dominio
│   │   │   │   │   ├── Cliente.java
│   │   │   │   │   ├── CuentaBancaria.java
│   │   │   │   │   ├── CuentaAhorro.java
│   │   │   │   │   ├── CuentaCorriente.java
│   │   │   │   │   └── Transaccion.java
│   │   │   │   └── ports/                    # Contratos (interfaces)
│   │   │   │       ├── CuentaRepository.java
│   │   │   │       └── TransaccionRepository.java
│   │   │   ├── application/                  # Casos de uso / Servicios
│   │   │   │   ├── CuentaService.java
│   │   │   │   └── TransaccionService.java
│   │   │   └── infrastructure/
│   │   │       ├── adapters/                 # Implementaciones de puertos
│   │   │       │   ├── CuentaJpaAdapter.java
│   │   │       │   └── TransaccionJpaAdapter.java
│   │   │       └── controllers/              # Controladores REST
│   │   │           ├── CuentaController.java
│   │   │           └── TransaccionController.java
│   │   └── resources/
│   │       └── application.yml               # Configuración
│   └── test/
│       └── java/com/bank/
│           └── application/                  # Pruebas unitarias
│               ├── CuentaServiceTest.java
│               └── TransaccionServiceTest.java
├── pom.xml
└── README.md
```

## Arquitectura

```
┌─────────────────────────────────────────────────────────────┐
│                    CAPA DE INTERFAZ                         │
│  ┌──────────────────┐    ┌──────────────────┐              │
│  │ CuentaController │    │TransaccionController│           │
│  └────────┬─────────┘    └────────┬─────────┘              │
└───────────┼───────────────────────┼─────────────────────────┘
            │                       │
            ▼                       ▼
┌─────────────────────────────────────────────────────────────┐
│                   CAPA DE APLICACIÓN                        │
│  ┌──────────────────┐    ┌──────────────────┐              │
│  │  CuentaService   │    │ TransaccionService│             │
│  └────────┬─────────┘    └────────┬─────────┘              │
└───────────┼───────────────────────┼─────────────────────────┘
            │                       │
            ▼                       ▼
┌─────────────────────────────────────────────────────────────┐
│                      CAPA DE DOMINIO                        │
│  ┌──────────────────┐    ┌──────────────────┐              │
│  │   Cliente        │    │  CuentaBancaria  │              │
│  │   (Entidad)      │    │  (Entidad Base)  │              │
│  └──────────────────┘    └────────┬─────────┘              │
│                                    │                        │
│                    ┌───────────────┼───────────────┐        │
│                    ▼               ▼               ▼        │
│            ┌─────────────┐ ┌─────────────┐ ┌─────────────┐ │
│            │CuentaAhorro │ │CuentaCorriente│ │Transaccion │ │
│            └─────────────┘ └─────────────┘ └─────────────┘ │
│                                                             │
│  ┌──────────────────┐    ┌──────────────────┐              │
│  │CuentaRepository  │    │TransaccionRepository│           │
│  │    (Puerto)      │    │     (Puerto)      │              │
│  └──────────────────┘    └──────────────────┘              │
└─────────────────────────────────────────────────────────────┘
            │                       │
            ▼                       ▼
┌─────────────────────────────────────────────────────────────┐
│                   CAPA DE INFRAESTRUCTURA                   │
│  ┌──────────────────┐    ┌──────────────────┐              │
│  │ CuentaJpaAdapter │    │TransaccionJpaAdapter│           │
│  └──────────────────┘    └──────────────────┘              │
│                                                             │
│  Base de Datos H2 (en memoria)                              │
└─────────────────────────────────────────────────────────────┘
```

## Configuración

La aplicación está configurada para usar una base de datos H2 en memoria. Los parámetros de configuración se encuentran en `src/main/resources/application.yml`:

```yaml
spring:
  application:
    name: bank-system
  datasource:
    url: jdbc:h2:mem:bankdb
    driver-class-name: org.h2.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
  h2:
    console:
      enabled: true
```

La consola H2 está disponible en: `http://localhost:8080/h2-console`

## Compilación y Ejecución

### Compilar el proyecto

```bash
mvn clean compile
```

### Ejecutar la aplicación

```bash
mvn spring-boot:run
```

La aplicación arrancará en: `http://localhost:8080`

### Ejecutar pruebas

```bash
mvn test
```

### Generar paquete

```bash
mvn package
```

## API REST - Endpoints Disponibles

### Clientes

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/api/clientes` | Crear nuevo cliente |
| GET | `/api/clientes/{id}` | Obtener cliente por ID |
| GET | `/api/clientes` | Listar todos los clientes |
| PUT | `/api/clientes/{id}` | Actualizar cliente |
| DELETE | `/api/clientes/{id}` | Eliminar cliente |

### Cuentas

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/api/cuentas` | Crear nueva cuenta |
| GET | `/api/cuentas/{numero}` | Obtener cuenta por número |
| GET | `/api/cuentas` | Listar todas las cuentas |
| GET | `/api/cuentas/cliente/{clienteId}` | Listar cuentas por cliente |
| POST | `/api/cuentas/{numero}/depositar` | Realizar depósito |
| POST | `/api/cuentas/{numero}/retirar` | Realizar retiro |
| POST | `/api/cuentas/{numero}/transferir` | Transferencia a otra cuenta |
| POST | `/api/cuentas/ahorro/{numero}/interes` | Aplicar intereses |

### Transacciones

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/transacciones/cuenta/{numeroCuenta}` | Historial de transacciones |
| GET | `/api/transacciones` | Listar todas las transacciones |

## Documentación OpenAPI

La documentación interactiva de la API está disponible en:

- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8080/v3/api-docs`

## Principios OOP Implementados

### Encapsulamiento

Los atributos de las entidades son privados y solo se accede a través de métodos getters y setters. La lógica de negocio está contenida dentro de las clases del dominio.

### Herencia

- `CuentaBancaria` es la clase base abstracta
- `CuentaAhorro` y `CuentaCorriente` heredan de `CuentaBancaria`
- Cada tipo de cuenta tiene comportamientos específicos

### Polimorfismo

Los servicios utilizan la clase base `CuentaBancaria` para manejar diferentes tipos de cuentas de manera uniforme, delegando el comportamiento específico a cada subclase.

### Abstracción

- Los puertos (`CuentaRepository`, `TransaccionRepository`) definen contratos sin exponer detalles de implementación
- Los adaptadores implementan los puertos para tecnologías específicas

## Tecnologías Utilizadas

- **Java 21** - Lenguaje de programación
- **Spring Boot 3.5** - Framework de aplicación
- **Spring Data JPA** - Persistencia de datos
- **H2** - Base de datos en memoria
- **Lombok** - Reducción de boilerplate
- **SpringDoc OpenAPI** - Documentación de API
- **Maven** - Gestión de dependencias

## Licencia

Este proyecto es con fines educativos y de demostración.
```
