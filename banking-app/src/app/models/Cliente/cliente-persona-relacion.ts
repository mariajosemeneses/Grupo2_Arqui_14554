import { Cliente } from "./cliente";
import { TipoRelacion } from "./tipo-relacion";

export class ClientePersonaRelacion {
  codClientePersonaRelacion: number;
  codTipoRelacion: TipoRelacion;
  codClienteEmpresa: Cliente;
  codClientePersona: Cliente;
  estado: string;
  fechaInicio: Date;
  fechaFin: Date;
}
