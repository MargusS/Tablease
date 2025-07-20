#!/bin/bash

SERVICE=$1   # Nombre del servicio (ej: menu-service)
CONTEXT=$2   # Nombre del bounded context (opcional)

if [ -z "$SERVICE" ]; then
  echo "Uso: ./create-bc.sh <service-name> [bounded-context]"
  exit 1
fi

# Quitar sufijo -service o _service
PACKAGE_NAME=$(echo $SERVICE | sed -E 's/(-service|_service)//g')

# Definir ruta base
BASE_DIR=services/$SERVICE/src/main/java/com/tablease/$PACKAGE_NAME

# Si no hay contexto, usar root
if [ -z "$CONTEXT" ]; then
  TARGET_DIR=$BASE_DIR
else
  TARGET_DIR=$BASE_DIR/$CONTEXT
fi

# Crear estructura de carpetas
mkdir -p $TARGET_DIR/domain/VO
mkdir -p $TARGET_DIR/app/gateway
mkdir -p $TARGET_DIR/app/interactors
mkdir -p $TARGET_DIR/app/facade
mkdir -p $TARGET_DIR/infra/config
mkdir -p $TARGET_DIR/infra/mappers
mkdir -p $TARGET_DIR/infra/persistence
mkdir -p $TARGET_DIR/presentation/controllers
mkdir -p $TARGET_DIR/presentation/exceptions
mkdir -p $TARGET_DIR/presentation/presenter

echo "Bounded Context creado en: $TARGET_DIR"
