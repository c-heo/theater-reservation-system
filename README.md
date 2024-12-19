# 事前準備
## 共通
- OS に合わせた docker desktop をインストール
  - [Windows](https://docs.docker.com/desktop/install/windows-install/)
  - [Mac](https://docs.docker.com/desktop/install/mac-install/)
## windows の場合
1. Microsoft Store から Ubuntu をインストール
2. 「スタートボタン」→「Windowsシステムツール」→「コントロールパネル」→「プログラム」→「Windowsの機能の有効化または無効化」を開き、「Linux用Windowsサブシステム（WSL）」と「仮想マシン プラットフォーム」にチェックを入れ「OK」
3. 再起動
4. Ubuntu を起動し、ユーザー名とパスワードを入力
5. Ubuntu で homebrew をインストールする
```
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
(echo; echo 'eval "$(/home/linuxbrew/.linuxbrew/bin/brew shellenv)"') >> /home/***/.bashrc # *** はユーザー名
eval "$(/home/linuxbrew/.linuxbrew/bin/brew shellenv)"
```

# セットアップ

## docker イメージ作成
```
docker-compose build
docker-compose up -d
docker-compose exec backend bash

# bash で以下を実行
microdnf install findutils
sh gradlew build

#jarファイルがあるか確認
ls build/libs/
java -jar build/libs/theater-reservation-system-0.0.1-SNAPSHOT.jar
```

## サーバー起動
```
docker-compose up
open http://localhost:3000/
```
