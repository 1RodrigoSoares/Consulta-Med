# ConsultaMed : Sistema de Gerenciamento de Consultas Médicas

Um sistema para gerenciar consultas médicas, implementando padrões de projeto como **Factory Method**, **Singleton**, **State** e **Iterator**. Desenvolvido em Java.

---

## 🧠 Padrões de Projeto Utilizados
| Padrão                      | Classes Envolvidas                          |
|-----------------------------|---------------------------------------------|
| **Factory Method**          | `FabricaConsulta`, `FabricaConsultaAgendada`, `FabricaConsultaEmergencial` |
| **Singleton**               | `GerenciadorDeConsultas`                    |
| **State**                   | `EstadoConsulta`, `EstadoAgendada`, `EstadoCancelada`, `EstadoEmAndamento`, `EstadoConcluida` |
| **Iterator**                | `ListaConsultas`, `IteradorConsultas`       |
| **Strategy**                | `EstrategiaAgendamento`, `EstrategiaListaEspera`, `EstrategiaPrioridadeIdosa` |
| **Observer**                | `Observable`, `Observer`, `Paciente`, `Medico` |
| **Mediator**                | `MediadorClinica`                           |
| **Chain of Responsibility** | `ManipuladorEncaminhamento`, `ManipuladorCardiologista`, `ManipuladorOrtopedista` |
| **Template Method**         | `ProcessoConsulta`, `ProcessoConsultaEmergencia`, `ProcessoConsultaAgendada` |


## 📊 Diagrama de Classes
![ConsultaMedFinal drawio](https://github.com/user-attachments/assets/c57d4a7a-8648-4ce9-9754-8e34da7cc3e8)
