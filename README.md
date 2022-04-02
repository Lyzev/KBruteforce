<h1 align="center">KBruteforce</h1>

<p align="center">A library for brute forcing.</p>

<div align="center">
    <a href="https://discord.gg/5UmsQP4MFH"><img src="https://img.shields.io/discord/610120595765723137?logo=discord" alt="Discord"/></a>
    <br><br>
    <img src="https://img.shields.io/github/last-commit/Lyzev/KBruteforce" alt="GitHub last commit"/>
    <img src="https://img.shields.io/github/commit-activity/w/Lyzev/KBruteforce" alt="GitHub commit activity"/>
    <br>
    <img src="https://img.shields.io/github/languages/code-size/Lyzev/KBruteforce" alt="GitHub code size in bytes"/>
    <img src="https://img.shields.io/github/contributors/Lyzev/KBruteforce" alt="GitHub contributors"/>
</div>

## Usage

[![](https://jitpack.io/v/Lyzev/KBruteforce.svg?label=Release)](https://jitpack.io/#Lyzev/KBruteforce)

### Import

Replace `${version}` with the current version!

<details>
        <summary>Gradle KTS</summary>

```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.Lyzev:KBruteforce:${version}")
}
```

</details>

<details>
        <summary>Gradle Groovy</summary>

```
repositories {
	maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.Lyzev:KBruteforce:${version}'
}
```

</details>

<details>
        <summary>Maven</summary>

```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.Lyzev</groupId>
        <artifactId>KBruteforce</artifactId>
        <version>${version}</version>
    </dependency>
</dependencies>
```

</details>

<details>
        <summary>Raw Jar</summary>

1. Go to the [release page](https://github.com/Lyzev/KBruteforce/releases).
2. Download KBruteforce-${version}.jar.
3. Add the jar to your classpath.

</details>

### Example

```kotlin
fun main() {
    var bruteforce: Bruteforce<*> =
        StringBruteforce(charArrayOf('a', 'b', 'c', 'd'), 1, 5) // chars to bruteforce, start length, end length
    var multiBruteforce =
        MultiBruteforce(bruteforce, 50) { // bruteforce instance, amount of threads, unit/thread to execute
            println(SHA3.hash256(it.toString())) // prints the sha3 256 hash of the current bruteforce string
        }
    multiBruteforce.start() // starts the multithreading

    bruteforce = DictionaryBruteforce(
        arrayOf("Game", "Password", "Life"),
        1,
        5
    ) // word combinations to bruteforce, start length, end length
    multiBruteforce =
        MultiBruteforce(bruteforce, 50) { // bruteforce instance, amount of threads, unit/thread to execute
            println(it.toString()) // prints the current bruteforce string
        }
    multiBruteforce.start() // starts the multithreading
}
```

## Documentation

You can find the documentation [here](https://lyzev.github.io/KBruteforce/dokka).

## Code Quality Monitoring

You can find the qodana report [here](https://lyzev.github.io/KBruteforce/qodana).

## Bugs and Suggestions

Bug reports and suggestions should be made in this repo's [issue tracker](https://github.com/Lyzev/KBruteforce/issues)
using the templates provided. Please provide as much information as you can to best help us understand your issue and
give a better chance of it being resolved.

## Important

Please note that this repository is for educational purposes only. No contributor, major or minor, are to fault for any
actions done with this library.