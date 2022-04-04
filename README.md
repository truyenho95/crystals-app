# Crystals App

Crystals App is a base project about authentication and authorization.

| Sub Project    | Description          |
| -------------- | -------------------- |
| Ruby Project   | Resource Server (RS) |
| Jasper Project | Keycloak Server (AS) |

## Installation

Use this [docker image](https://quay.io/repository/keycloak/keycloak) to install [Keycloak](https://www.keycloak.org/downloads).

```bash
docker image pull quay.io/keycloak/keycloak:17.0.1
docker image tag quay.io/keycloak/keycloak:17.0.1 keycloak:17.0.1
docker run -d --name my-keycloak -p 8082:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin keycloak:17.0.1 start-dev
```

## License
[Apache](https://www.apache.org/licenses/LICENSE-2.0/)
