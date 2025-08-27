# Ultra Leaf Decay – Instant Leaf Removal with High Optimization

**Ultra Leaf Decay** makes leaves disappear immediately after trees are cut down, drastically improving server performance.

**Join our** [**Discord**](https://discord.gg/YGzA4UxzFB) — discover other cool plugins, suggest new features, or get help with configurations.

### Features ✨

- **Instant Leaf Cleanup**  
  Leaves vanish the moment logs are broken, eliminating floating leaf blocks.

- **Vanilla-Compatible Distance**  
  Configurable max log distance (1–7) matching or surpassing vanilla behavior.

- **Performance Boost**  
  Highly optimized to reduce server lag during large-scale tree felling.

- **Hot Reload**  
  Reload the plugin config on-the-fly with `/ultraleafdecay reload`.

### Main config (`config.yml`) ⚙️

<details>
  <summary><strong>config.yml</strong></summary>

  ```yaml
# Join our discord - https://discord.gg/YGzA4UxzFB you can find other cool plugins there.
# Permissions
# "ultraLeafDecay.reload" - permission required to use "/ultraleafdecay reload" command

# Maximum distance from leaves to the nearest log block
# Leaves with distance greater than or equal to this value will be destroyed
# Default: 6 (matches vanilla Minecraft behavior)
# Range: 1-7 (values outside this range may cause unexpected behavior)
maxLogDistance: 6

# supports MiniMessage
noPermissionToReload: "<red>✘ <white>You don't have permission to reload Config!"
configReloaded: "<green>✔ <white>Config reloaded!"
````

</details>

### Permissions 🔐

| Permission Node         | Description                        |
| ----------------------- | ---------------------------------- |
| `ultraLeafDecay.reload` | Allows reloading the plugin config |

### Commands 📟

| Command                  | Description                     |
| ------------------------ | ------------------------------- |
| `/ultraleafdecay reload` | Reload the plugin configuration |
