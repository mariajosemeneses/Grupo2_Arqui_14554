import { Cliente } from "../Cliente/cliente";
import { TipoCuenta } from "./tipo-cuenta";

export class Cuenta {
  codCuenta: number;
  codTipoCuenta: TipoCuenta;
  codCliente: Cliente;
  numeroCuenta: string;
  saldoContable: number;
  saldoDisponible: number;
  estado: string;
  fechaCreacion: Date;
  fechaUltimoCambio: Date;
}
