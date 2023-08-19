#  Amarradero Llanero - Spring Boot

This repository combines Camunda (business process automation platform) with a Spring Boot application and a PostgreSQL database for the "Amarradero Llanero" restaurant, all supported by Amazon Web Services (AWS) services such as RDS and EC2 for the database instance and for running the program in a virtual machine, respectively. 

***The program has two ways to run, locally or in the cloud.***

## Index

1. [Description](#description)
2. [Usage](#usage)
3. [Funcionality](#funcionality)

## Description

The integration of Camunda and Spring Boot plays a key role in improving the automation and efficiency of business processes. The Amarradero Llanero project is designed using **Docker** containers to ensure both portability and scalability of the application. Leveraging a **PostgreSQL database** from the **AWS service**, the project efficiently stores relevant data while orchestrating processes and tasks through Camunda to streamline activities.

Focused on creating a restaurant order management system, the project leverages Spring Boot's project initializer that integrates the Camunda engine (https://start.camunda.com/). This application allows users to register, place orders to the various sections of the restaurant and seamlessly automates workflow processes. In particular, all user and order information is securely stored in the PostgreSQL database hosted on the AWS service.

The database store the following attributes for each instance of BPM model:<br><br>
**Table Users**
| Id     | Username        | Fullname       | Email           | Password     |
| ------------- | --------------------|-----------------------|--------------------|--------------- |
|Unique identifier| User's username | Full name | Email address | Password |

**Table Orders**
| Id     | CurrentDate        | PedidoAsadero       | CantPedidoAsadero           | PedidoCocina     | CantPedidoCocina | pedidoBar| cantPedidoBar |
| ------------- | ---------|-----------|-----------|------------|------------|--------|--------------- |
|Unique identifier for each record.| The date when the order was placed. | The order from the grill section. | The quantity of the grill order. | The order from the kitchen section. | The quantity of the kitchen order. |  The order from the bar section.  |  The quantity of the bar order. |

## Usage
Before running the program, make sure of the following **(the easiest is with AWS)**:

***if you want to run it locally:***

1. **Code editor**: If you want to modify AmarraderoLlanero, we recommend you to use Visual Studio Code (VS Code). You can download it from the [official website].(https://code.visualstudio.com/download).

2. **Version control system**: Install GIT from the [official website](https://git-scm.com/downloads).

3. **Docker Desktop**: To use Docker correctly follow the steps below:
    - **Step 1**: Install Docker from the [official website](https://www.docker.com/products/docker-desktop/).*(If you already have Docker Desktop installed, skip this step).*
    - **Step 2**: Create a Docker Hub account from the [official website](https://hub.docker.com/signup), and log in to Docker Desktop.
    *(If you already have an account, log in directly to Docker Desktop)*

5. **WSL2**: According to your need:
    - Use the following command to install WSL2
    `wsl --list --o` to know the available distributions.
    `wsl --install -d "distribution-version"` to install WSL2 with a specific distribution.
    - Use the following command for upgrade to WSL2
    `wsl --version` if you want to know the installed WSL version
    `wsl --set-default-version 2` to change the version to WSL2.

6. **PgAdmin**: [official website](https://www.postgresql.org/download/) to install PostgreSQL and pgAdmin for the database manage.

7. Create a database called amarraderollanero with the tables Users and Orders with the help of pgAdmin and modify in src/main/resources/application.properties the following:

    ````configuration
    spring.datasource.url=jdbc:postgresql://localhost/amarraderollanero
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ````

8. **Clone the repository**: Use the following command to clone the repository: `git clone https://github.com/BPMN-sw-evol/AmarraderoLlanero-SB`

9. Inside the previously cloned repository, in a terminal run the following command to create the image from the Dockerfile: `docker build -t amarraderolocal .`

10. Now run the following command to run the docker container: `docker run -p 8080:8080 amarraderolocal`

11. Ready! Use the program.

***if you want to run it in the cloud:***

***IMPORTANT NOTE:*** in this [link](https://docs.google.com/document/d/1DGI8_nkBq9eD0TAqSlSBcFuYAjRvll_k/edit?usp=sharing&ouid=116840209235218873766&rtpof=true&sd=true) there is a STEP BY STEP guide on how to create and configure the AWS EC2 and RDS services for this project to run quickly and easily.

1. Sign up for Amazon Web Service. [official website](https://portal.aws.amazon.com/billing/signup#/start/email) (if you are already registered, skip this step.).

2. Log in to the AWS Management Console using your credentials.: [official website](https://aws.amazon.com/marketplace/management/signin) (if you are already registered, skip this step.).

3. Virtual machine and instance database creation [creation guide](https://docs.google.com/document/d/1DGI8_nkBq9eD0TAqSlSBcFuYAjRvll_k/edit#heading=h.e10giwd1tsyw)

4. When the instance database is running, you must connect to EC2 [connection guide](https://docs.google.com/document/d/1DGI8_nkBq9eD0TAqSlSBcFuYAjRvll_k/edit#heading=h.z8hzk2vh096y)

5. Make the update and Initial Configuration [update and configuration guide](https://docs.google.com/document/d/1DGI8_nkBq9eD0TAqSlSBcFuYAjRvll_k/edit#heading=h.55zhux44rzwd)

6. Configure the project Amarradero Llanero [Amarradero Llanero configuration guide](https://docs.google.com/document/d/1DGI8_nkBq9eD0TAqSlSBcFuYAjRvll_k/edit#heading=h.z7qzjimlcuv6)

7. Execute the project [execution guide](https://docs.google.com/document/d/1DGI8_nkBq9eD0TAqSlSBcFuYAjRvll_k/edit#heading=h.k21b1ys9cb1d)

8. Ready! Use the program.

## Funcionality

For the case of AWS deployment, you must use the virtual marchine IP adress with the port 8080 to start de program. Example: if you virtual machine IP is 18.221.143.237 you must open in your browser it:

    18.221.143.237:8080

