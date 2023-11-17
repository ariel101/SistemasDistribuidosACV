<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Cuenta>
 */
class CuentaFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            //
            'nro_cuenta' => $this->faker->unique()->bankAccountNumber,
            'cliente_id' => function () {
                // Puedes ajustar esta lógica según tus necesidades para asignar un cliente_id válido
                return \App\Models\Cliente::factory()->create()->id;
            },
            'saldo' => $this->faker->randomFloat(2, 0, 100000),
            'moneda' => $this->faker->randomElement(['USD', 'EUR', 'GBP','BOB']),
        ];
    }
}
