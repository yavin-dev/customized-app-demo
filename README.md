<p align="center">
  <a href="https://yavin.dev">
    <img alt="yavin-logo" src="assets/yavin-logo-transparent.svg" height="150px"/>
  </a>
</p>
<h1 align="center">Customized Yavin App Demo</h1>
<p align="center">Rapidly build production quality analytics applications</p>
<p align="center">
    <a href="https://yavin.dev">Docs</a> - <a href="https://yavin-dev.github.io/framework">Demo</a> - <a href="https://github.com/yavin-dev/framework/discussions">Community</a>
</p>

## Customized Yavin App Demo

This is an demo Yavin app to showcase how Yavin can be customize.
## Getting Started

-  Install Java 8 or greater (more info [here](https://yavin.dev/pages/guide/02-start.html#prerequisites))
- `git clone https://github.com/yavin-dev/customized-app-demo.git`
- `cd customized-app-demo`

### Start Yavin App

- `./gradlew bootRun`
- Open [http://localhost:8080](http://localhost:8080)

### Build & Test Deployable Jar

- Build & Test:`./gradlew build`
- Build Only:`./gradlew build -x test`
- Build For Prod:`./gradlew build -Penvironment=production`
- Run Jar: `java -jar ws/build/libs/yavin-ws.jar`

### Run Tests

- Test All: `./gradlew test`
- Test UI: `./gradlew ui:test`
- Test WS: `./gradlew ws:test`
 
### Clean Build

- Clean All: `./gradlew clean`
- Clean UI: `./gradlew ui:clean`
- Clean WS: `./gradlew ws:clean`

### Customize

- Define your [DB config](./ws/src/main/resources/demo-configs/db/sql/DemoConnection.hjson) (currently loads data via the [create-demo-data.sql](./ws/src/main/resources/create-demo-data.sql) script)
- Define your [table config](./ws/src/main/resources/demo-configs/models/tables/DemoTables.hjson)
- Check out our [installation guide](https://yavin.dev/pages/guide/03-start.html#yavin-detailed-installation-guide) for more info

## Resources

[Yavin framework resources](https://github.com/yavin-dev/framework#resources)

More documentation can be found on [yavin.dev](https://yavin.dev)

## License

This project is licensed under the [MIT License](LICENSE.md).
