import { Cliente } from "../Cliente/cliente";

export class CuentaIntervinientes {
  codCuenta: number;
  codClientePersona: Cliente;
  fechaInicio: Date;
  fechaFin: Date;
  estado: string;
}
