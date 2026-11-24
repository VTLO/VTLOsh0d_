<p align="center">
  <img src="assets/banner.svg" alt="VTLOsh0d_" width="100%"/>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/AUTEUR-VTLO-ff8200?style=for-the-badge&labelColor=333" alt="VTLO"/>
  <img src="https://img.shields.io/badge/ANDROID-KOTLIN-ff8200?style=for-the-badge&labelColor=333" alt="Android"/>
  <img src="https://img.shields.io/badge/WEB-HTML%20%2F%20JS-ff8200?style=for-the-badge&labelColor=333" alt="Web"/>
  <img src="https://img.shields.io/badge/DORKS-128%2B-ff8200?style=for-the-badge&labelColor=333" alt="Dorks"/>
</p>

# VTLO · VTLOsh0d_

> Toutes les requêtes Shodan du cheat-sheet, dans une app Android et une app web PC.
> Votre clé API reste sur votre appareil.

VTLOsh0d_ lance chaque type de requête de ce cheat-sheet contre l'API officielle
Shodan avec **votre propre clé API**. Les deux applications ouvrent sur un
**court guide animé en français** au premier lancement.

## Fonctionnalités

| | |
|---|---|
| **128+ dorks** | 11 catégories : filtres de base, services exposés, types d'appareils, systèmes industriels, infrastructure réseau, NAS, webcams, imprimantes, domotique… |
| **Filtres** | Pays, ville, organisation, produit, OS, port, type d'appareil, combinés à n'importe quel dork |
| **Navigateur intégré** | Android : WebView avec User-Agent configurable (Desktop, Android, iPhone, Googlebot, personnalisé) et bouton « Open » sur chaque résultat |
| **Thème rétro** | Orange sur noir, police monospace |
| **Confidentialité** | La clé API n'est envoyée qu'à `api.shodan.io` |

## Téléchargements

- **Android** : [`android/dist/shodan-dorks-debug.apk`](android/dist/shodan-dorks-debug.apk)
  (`adb install -r shodan-dorks-debug.apk`). Sources et build dans [`android/`](android/).
- **Web (PC)** : [`web/index.html`](web/index.html) : fichier autonome, sans build.
  Ouvrez-le dans un navigateur, ou servez le dossier `web/` (`python3 -m http.server`).

## Utilisation

1. Créez une clé API sur [shodan.io](https://account.shodan.io/) et collez-la dans l'app.
2. Choisissez un dork dans le catalogue, ou écrivez votre requête.
3. Ajoutez des filtres si besoin, puis lancez la recherche.
4. Touchez un résultat pour l'ouvrir dans le navigateur.
