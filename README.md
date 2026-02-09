# Carpet DWK Addition

![Icon](src/main/resources/assets/dwk/icon.png)

A Carpet Mod extension that provides control over fluid mechanics in Minecraft.
Developed by **Mimic_enzymes**.

## 📖 Features (功能)

This mod adds new rules to `/carpet` to control fluid behaviors:

### `stopFluidFlow`
- **Description**: Prevents water and lava from spreading to new blocks.
- **Default**: `false`
- **Use case**: Useful for keeping builds clean and reducing lag.
- **Command**: `/carpet stopFluidFlow true`

### `preventFluidInteraction`
- **Description**: Prevents fluids from interacting with the world (e.g., water + lava = stone/obsidian).
- **Default**: `false`
- **Use case**: Prevents accidental stone generation from jamming flying machines and redstone contraptions.
- **Command**: `/carpet preventFluidInteraction true`

## 📦 Installation (安装)

1. Install [Fabric Loader](https://fabricmc.net/).
2. Install [Fabric API](https://modrinth.com/mod/fabric-api).
3. Install [Carpet Mod](https://modrinth.com/mod/carpet).
4. Drop the `carpet-dwk-addition-1.0.0.jar` into your `mods` folder.

## 📄 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

---
*Created by Mimic_enzymes*