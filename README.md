# Lightning Money

#### This application's primary goal is to serve as a manager of a Lightning Network Bitcoin wallet, showcasing its speed and efficiency as a proof-of-concept. It emphasizes the potential for rapid and cost-effective transactions.

In addition to this, later in development, a new branch will be created in the early stages of the application, serving as a starting point for your MVVM Clean architecture.

# Lightning Network (LN)

If you want to take a deeper dive into what the Lightning Network is about, please take a look at my [internship report](assets/Filipe_Morgado_MobileMoney_BlockchainTransactions.pdf) `chapters 2,3 and 4` about it.

In this application, I will be using [LNbits](www.lnbits.com) as the main provider for everything needed regarding trading bitcoin using the LN. [LNbits API](https://legend.lnbits.com/docs#/default/api_create_wallet_api_v1_wallet_post) will make it possible to manage a Lightning Network Bitcoin wallet.
They also provide a [demo](https://legend.lnbits.com/) in which you can use to create your own wallet and trade real bitcoin using the LN on the browser. The experience in the application is expected to be the same. 

# Disclaimer: 

`Please take into consideration that the security of the funds cannot be guaranteed. Even though you can create a wallet and trade actual bitcoin, due to LNBits API main objective being LN demonstrations, this wallet intent is also to demonstrante LN capabilities in real world scenarios.` 

# Design

Please note that the design of the application will be based on this [public available figma bitcoin wallet design](https://www.figma.com/file/dP4iIoJPC7rb66qkvEI12L/Bitcoin-Wallet-UI-Kit-%26-Design-System-(Community)?type=design&node-id=4349-64998&mode=design&t=UFzDp1EWrVKFRN6E-0).

The design will be overall equal or almost equal to some of the screens, with slight aditions and color changes. Below, are the first screens available currently in the application.

<div align="center">
  <img src="assets/lw_create_wallet.png?raw=true" width="280" height="650" alt="Image 1">
  &nbsp;&nbsp;&nbsp; <!-- Add more "&nbsp;" as needed for spacing -->
  <img src="assets/lw_disclaimer.png?raw=true" width="280" height="650" alt="Image 2">
  &nbsp;&nbsp;&nbsp;
  <img src="assets/lw_wallet_name.png?raw=true" width="280" height="650" alt="Image 3">
</div>

# Kotlin + MVVM + Clean Architecture + Coroutines + Koin

This project aims to establish a robust structure for Android app development, integrating essential technologies and principles endorsed by Google and widely embraced within the Android development community.

## Clean Architecture

Clean Architecture promotes the separation of concerns, facilitating loose coupling for code that is not only more testable but also adaptable. The architecture is organized into three modules: presentation, data, and domain.

### Key Components:

#### Presentation Layer:
- Integrates Android Framework, `MVVM pattern`, and Dependency Injection (DI) module (`Koin`).
- Dependencies include access to domain for use cases and DI for dependency injection.

#### Domain Layer:
- Encapsulates business logic.
- Entities represent business objects.
- Repositories define interfaces used by use cases.
- Use Cases (Interactors) execute specific actions.

#### Data Layer:
- Implements repositories declared in the domain.
- Manages data retrieval from various sources, such as databases and services.

### Flows and State Management

Flows, including `SharedFlow` and `StateFlow`, are central to the application's reactive architecture:

- **SharedFlow:**
  - Used for emitting events that multiple subscribers can observe.
  - Ideal for handling events such as navigation or user interactions.

- **StateFlow:**
  - Used for representing UI state that can be observed by the View.
  - Ensures that the latest state is always delivered to observers.

## Dependency Injection with Koin

`Koin` is employed for dependency injection, supporting SOLID principles, specifically dependency inversion and single responsibility.

## Coroutines

Coroutines manage background threads, simplifying code by eliminating the need for callbacks. Coroutines are employed for background tasks, aligning with the concept of use cases.

## MVVM Concepts

Using this text, we follow certain conventions and principles for the different architectural components:

- **View:**
  - Observes UI State from ViewModel.
  - Delegates user events to ViewModel.
  - Navigates based on ViewModel instructions.

- **ViewModel:**
  - Communicates with use cases.
  - Constructs UI State.
  - Notifies UI state changes.
  - Determines when and where to navigate and sends events accordingly.

- **Use case:**
  - Manages app business logic.
  - Calls Lib Interactor Interfaces.
  - Prepares and returns state to ViewModel.
  - Can depend on a series of sub-use cases to perform the work.
  - Utilizes mapper classes to map Lib model objects to App objects.

- **Interactors:**
  - Handles lib business logic.
  - Calls repositories.
  - Prepares and returns state to UseCase.

- **Repositories:**
  - Initiates network calls with multiple services to construct business models.
  - Persists business models in the local database.
  - Manages memory caches, preparing and invalidating them.
  - Utilizes mapper classes to map network and DB objects into business ones.

**Interactors Absent Scenario:**

In cases where Interactors are not present, the business logic typically resides within the Use Case itself. The Use Case directly handles the application's business logic, calling repositories and preparing the state to be returned to the ViewModel. This approach maintains separation of concerns and allows for a clean and modular architecture.

## License

 ```
   Copyright 2019 Filipe Morgado
   
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 ```
